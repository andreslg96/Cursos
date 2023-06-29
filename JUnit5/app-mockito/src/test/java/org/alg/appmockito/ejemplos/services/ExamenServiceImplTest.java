package org.alg.appmockito.ejemplos.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.alg.appmockito.ejemplos.models.Examen;
import org.alg.appmockito.ejemplos.repositories.ExamenRepository;
import org.alg.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.alg.appmockito.ejemplos.repositories.ExamenRepositoryOtro;
import org.alg.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {
	
	@Mock
	ExamenRepository repository;
	@Mock
	PreguntaRepository preguntaRepository;
	
	@InjectMocks
	ExamenServiceImpl service;
	
	@BeforeEach
	void setUp() {
		//MockitoAnnotations.openMocks(this); una forma de que funcionen las inyecciones
		//los mocks los vamos a hacer desde los atributos con las notaciones para inyección de dependencias
//		repository = mock(ExamenRepositoryOtro.class);
//		preguntaRepository = mock(PreguntaRepository.class);
//		service = new ExamenServiceImpl(repository, preguntaRepository);		
	}

	@Test
	void findExamenPorNombre() {
		//ExamenRepository repository = Mockito.mock(ExamenRepository.class); //new ExamenRepositoryImpl(); se elimina como podemos quitar la impl al tener aquí ya la lista con exámenes
//		ExamenRepository repository = mock(ExamenRepositoryOtro.class);//de esta forma es con el import estático de mockito
//		ExamenService service = new ExamenServiceImpl(repository); como estás dos líneas se van a repetir, las pasamos al BeforeEach
//		List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"), new Examen(6L, "Lenguaje"),
//				new Examen(7L, "Historia")); //Con esta lista podemos eliminar la impl, se comenta porque lo agregamos como constatne a la clase Datos
		
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");
		
		//assertNotNull(examen); lo cambiamos a assertTrue
		assertTrue(examen.isPresent());
		assertEquals(5L, examen.orElseThrow().getId());
		assertEquals("Matemáticas", examen.get().getNombre());
	}
	
	@Test
	void findExamenPorNombreListaVacia() {
		List<Examen> datos = Collections.emptyList();
		
		when(repository.findAll()).thenReturn(datos);
		Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");
		
		assertFalse(examen.isPresent());
		
	}
	
	@Test
	void restPreguntasExamen() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntaRepository.findPreguntasPorExamenId(5L)).thenReturn(Datos.PREGUNTAS); //podemos cambiar el 5L por anyLong()
		Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
		assertEquals(5, examen.getPreguntas().size());
		assertTrue(examen.getPreguntas().contains("aritmética"));
	}
	
	@Test
	void restPreguntasExamenVerify() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntaRepository.findPreguntasPorExamenId(5L)).thenReturn(Datos.PREGUNTAS); //podemos cambiar el 5L por anyLong()
		Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
		assertEquals(5, examen.getPreguntas().size());
		assertTrue(examen.getPreguntas().contains("aritmética"));
		verify(repository).findAll();
		verify(preguntaRepository).findPreguntasPorExamenId(5L);
	}
	
	@Test
	void restNoExisteExamenVerify() {
		//Given
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntaRepository.findPreguntasPorExamenId(5L)).thenReturn(Datos.PREGUNTAS); //podemos cambiar el 5L por anyLong()
		
		//When
		Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
		
		//Then
		assertNull(examen);
		verify(repository).findAll();
		verify(preguntaRepository).findPreguntasPorExamenId(5L);
	}
	
	@Test
	void testGuardarExamen() {
		//Given (entorno impulsado por comportamiento)
		Examen newExamen = Datos.EXAMEN;
		newExamen.setPreguntas(Datos.PREGUNTAS);
		when(repository.guardar(any(Examen.class))).then(new Answer<Examen>(){
			
			Long secuencia = 8L;
			
			@Override
			public Examen answer(InvocationOnMock invocation) throws Throwable {
				Examen examen = invocation.getArgument(0);
				examen.setId(secuencia++);
				return examen;
			}
			
		});
		
		//When
		Examen examen = service.guardar(newExamen);
		
		//Then
		assertNotNull(examen.getId());
		assertEquals(8L,examen.getId());
		assertEquals("Física", examen.getNombre());
		
		verify(repository).guardar(any(Examen.class));
		verify(preguntaRepository).guardarVarias(anyList());
	}
	
	@Test
	void testManejoException() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES_ID_NULL);
		when(preguntaRepository.findPreguntasPorExamenId(isNull())).thenThrow(IllegalArgumentException.class);
		Exception exception = assertThrows(IllegalArgumentException.class, ()->{
			service.findExamenPorNombreConPreguntas("Matemáticas");
		});
		assertEquals(IllegalArgumentException.class, exception.getClass());
		
		verify(repository).findAll();
		verify(preguntaRepository).findPreguntasPorExamenId(isNull());
	}
	
	@Test
	void testArgumentMatchers() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		service.findExamenPorNombreConPreguntas("Matemáticas");
		
		verify(repository).findAll();
		//verify(preguntaRepository).findPreguntasPorExamenId(argThat((arg)->arg !=null && arg.equals(5L))); //argThat se pude usar como .argThat de mockito, ArgumentMatchers etc
		verify(preguntaRepository).findPreguntasPorExamenId(argThat((arg)->arg !=null && arg >= 5L));
		//verify(preguntaRepository).findPreguntasPorExamenId(eq(5L)); 
	}
	
	@Test
	void testArgumentMatchers2() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		service.findExamenPorNombreConPreguntas("Matemáticas");
		
		verify(repository).findAll();
		verify(preguntaRepository).findPreguntasPorExamenId(argThat(new MiArgsMatchers()));
	}
	
	public static class MiArgsMatchers implements ArgumentMatcher<Long>{
		
		private Long argument;

		@Override
		public boolean matches(Long argument) {
			this.argument = argument;
			return argument != null && argument > 0;
		}

		@Override
		public String toString() {
			return "es un mensaje personalizado de error que imprime mockito en caso de que falle el test "
		+ argument + " debe ser un entero positivo";
		}
		
		
	}

}
