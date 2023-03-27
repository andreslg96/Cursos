package org.alg.junit5app.ejemplos.models;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.alg.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) //así se tiene solo una instancia de la clase y se puede quitar el static a BeforeAll y AfterAll y puede haber 
// interacción entre métodos, pero no es muy recomendable
class CuentaTest {
	Cuenta cuenta;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	@BeforeEach
	void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
		this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println("Iniciando el método");
//		System.out.println(" ejecutando: "+ testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName() 
//				+ " con las etiquetas " + testInfo.getTags()); //se cambia por el testReporter
		testReporter.publishEntry("ejecutando: "+ testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName() 
		+ " con las etiquetas " + testInfo.getTags());
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("finalizando el método de prueba");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("inicializando el test");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("finalizando el test");
	}
	
	@Tag("cuenta")
	@Nested
	@DisplayName("probando atributos de la cuenta corriente")
	class CuentaTestNombreSaldo{
		
		@Test
		@DisplayName("el nombre")
		void testNombreCuenta() { //(TestInfo testInfo, TestReporter testReporter)
			//Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345")); esto lo pasamos a initMetodoTest()
			// cuenta.setPersona("Andres");
			//System.out.println(" ejecutando: "+ testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName() //testInfo.getTestMethod().get().getName()
			//+ " con las etiquetas " + testInfo.getTags());
			testReporter.publishEntry(testInfo.getTags().toString());
			//System.out.println(testInfo.getTags());
			if(testInfo.getTags().contains("cuenta")) {
				//System.out.println("hacer algo con la etiqueta cuenta"); //justo abajo queda pero con Reporter
				testReporter.publishEntry("hacer algo con la etiqueta cuenta");
			}
			String esperado = "Andres";
			String real = cuenta.getPersona();
			assertNotNull(real, () -> "la cuenta no puede ser nula");
			// Assertions.assertEquals(esperado, real);
			assertEquals(esperado, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + esperado
					+ " sin embargo fue " + real);
			assertTrue(real.equals("Andres"), () -> "nombre cuenta esperada debe ser igual a la real"); // Es mejor el assertEquals
		}

		@Test
		@DisplayName("el saldo")
		void testSaldoCuenta() {
			//Cuenta cuenta = new Cuenta("andres", new BigDecimal("1000.12345"));
			assertNotNull(cuenta.getSaldo());
			assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
			assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
		}

		@Test
		@DisplayName("testeando referencias que sean iguales con el método equals.")
		void testReferenciaCuenta() {
			cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
			Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

			// assertNotEquals(cuenta2, cuenta);
			assertEquals(cuenta2, cuenta);
		}
	}
	
	@Nested
	class CuentaOperacionesTest{
		
		@Tag("cuenta")
		@Test
		void testDebitoCuenta() {
			//Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
			cuenta.debito(new BigDecimal("100"));
			assertNotNull(cuenta.getSaldo());
			assertEquals(900, cuenta.getSaldo().intValue());
			assertEquals("900.12345", cuenta.getSaldo().toPlainString());
		}
		
		@Tag("cuenta")
		@Tag("banco")
		@Test
		void testCreditoCuenta() {
			//Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
			cuenta.credito(new BigDecimal("100"));
			assertNotNull(cuenta.getSaldo());
			assertEquals(1100, cuenta.getSaldo().intValue());
			assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
		}
		
		@Test
		void testTransferirDineroCuentas() {
			Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
			Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

			Banco banco = new Banco();
			banco.setNombre("Banco del Estado");
			banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
			assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
			assertEquals("3000", cuenta1.getSaldo().toPlainString());
		}

	}
	
	
	@Test
	@Tag("cuenta")
	@Tag("error")
	void testDineroInsuficienteExceptionCuenta() {
		//Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
		Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
			cuenta.debito(new BigDecimal(1500));
		});
		String actual = exception.getMessage();
		String esperado = "Dinero insuficiente";
		assertEquals(esperado, actual);
	}

	
	@Test
	@Tag("cuenta")
	@Tag("banco")
	//@Disabled
	@DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
	void testRelacionBancoCuentas() {
		//fail();
		Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
		Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

		Banco banco = new Banco();
		banco.addCuenta(cuenta1);
		banco.addCuenta(cuenta2);

		banco.setNombre("Banco del Estado");
		banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
		assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(), 
									() -> "El valor de la cuenta2 no es el esperado"), 
				() -> assertEquals("3000", cuenta1.getSaldo().toPlainString(),
									() -> "El valor de la cuenta1 no es el esperado"), 
				() -> assertEquals(2, banco.getCuentas().size(), () -> "El banco no tiene las cuentas esperadas"), 
				() -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
				() -> assertEquals("Andres", banco.getCuentas().stream().filter(c -> c.getPersona().equals("Andres")).findFirst()
					.get().getPersona()), // Cuentas es un array, por lo que stream los convierte en string pero como
											// corriente, todos},
				() -> assertTrue(banco.getCuentas().stream().anyMatch(c -> c.getPersona().equals("John Doe"))));
	}
	
	@Nested
	class SistemaOperativoTest{
		
		@Test
		@EnabledOnOs(OS.WINDOWS)
		void testSoloWindows() {
		}
		
		@Test
		@EnabledOnOs({OS.LINUX, OS.MAC})
		void testSoloLinuxMac() {
		}
		
		@Test
		@DisabledOnOs(OS.WINDOWS)
		void testNoWindows() {
		}
		
	}
	
	@Nested
	class JavaVersionTest{
		
		@Test
		@EnabledOnJre(JRE.JAVA_8)
		void soloJdk8() {
		}
		
		@Test
		@DisabledOnJre(JRE.JAVA_17)
		void testNoJdk15() {
		}
		
	}
	
	@Nested
	class SistemProperties{
		
		@Test
		void imprimirSystemProperties() {
			Properties properties = System.getProperties();
			properties.forEach((k, v)-> System.out.println(k + ":" + v));
		}
		
		@Test
		@EnabledIfSystemProperty(named = "java.version", matches = "17.0.5")
		void testJavaVersion() {
		}
		
		@Test
		@DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
		void testSolo64() {
		}
		
		@Test
		@EnabledIfSystemProperty(named = "user.name", matches = "andre")
		void name() {
		}
		
		@Test
		@EnabledIfSystemProperty(named = "ENV", matches = "dev") //En propiedades de la ClaseTest -> -ea -DENV=dev
		void testDev() {
		}
	}
	
	@Nested
	class VariableAmbienteTest{
		
		@Test
		void imprimirVariablesAmbiente() {
			Map<String, String> getenv = System.getenv();
			getenv.forEach((k, v)-> System.out.println(k + " = " + v));
		}
		
		@Test
		@EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-17.0.2.*")
		void testJavaHome() {
		}
		
		@Test
		@EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8 ")
		void testProcesadores() {
		}
		
		@Test
		@DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
		void testEnv() {
		}
		
		@Test
		@DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
		void testEnvProdDisabled() {
		}
	}
	
	@Test
	@DisplayName("testSaldoCuentaDev")
	void testSaldoCuentaDev() {
		boolean esDev = "dev".equals(System.getProperty("ENV"));
		assumeTrue(esDev);
		assertNotNull(cuenta.getSaldo());
		assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
		assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
		assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
	}
	
	@Test
	@DisplayName("testSaldoCuentaDev 2")
	void testSaldoCuentaDev2() {
		boolean esDev = "dev".equals(System.getProperty("ENV"));
		assumingThat(esDev, ()->{
			assertNotNull(cuenta.getSaldo());
			assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
			assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
		});
	}
	
	@DisplayName("probando debito cuenta repetir")
	@RepeatedTest(value=5, name = "{displayName} Repetición número {currentRepetition} de {totalRepetitions}")
	void testDebitoCuentaRepetir(RepetitionInfo info) {
		if(info.getCurrentRepetition() == 3) {
			System.out.println("estamos en la repetición "+info.getCurrentRepetition());
		}
		cuenta.debito(new BigDecimal("100"));
		assertNotNull(cuenta.getSaldo());
		assertEquals(900, cuenta.getSaldo().intValue());
		assertEquals("900.12345", cuenta.getSaldo().toPlainString());
	}
	
	@Tag("param")
	@Nested
	class PruebasParametrizadasTest{
		@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
		@ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
		void testDebitoCuentaValueSource(String monto) {
			cuenta.debito(new BigDecimal(monto));
			assertNotNull(cuenta.getSaldo());
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
		}
		
		@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
		@CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
		void testDebitoCuentaCsvSource(String index, String monto) {
			System.out.println(index + " -> "+monto);
			cuenta.debito(new BigDecimal(monto));
			assertNotNull(cuenta.getSaldo());
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
		}
		
		@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
		@CsvSource({"200,100,John,Andres", "250,200,Pepe,Pepe", "300,300,maria,Maria", "510,500,Pepa,Pepa", "750,700,Lucas,Luca", "1000.12345,1000.12345,Cata,Cata"})
		void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
			System.out.println(saldo + " -> "+monto);
			cuenta.setSaldo(new BigDecimal(saldo));
			cuenta.debito(new BigDecimal(monto));
			cuenta.setPersona(actual);
			assertNotNull(cuenta.getSaldo());
			assertNotNull(cuenta.getPersona());
			assertEquals(esperado,actual);
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
		}
		
		@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
		@CsvFileSource(resources = "/data.csv") //el archivo debe estar en src/main/resources
		void testDebitoCuentaCsvFileSource( String monto) {
			cuenta.debito(new BigDecimal(monto));
			assertNotNull(cuenta.getSaldo());
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
		}
		
		@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
		@CsvFileSource(resources = "/data2.csv") //el archivo debe estar en src/main/resources
		void testDebitoCuentaCsvFileSource2( String saldo, String monto, String esperado, String actual) {
			cuenta.setSaldo(new BigDecimal(saldo));
			cuenta.debito(new BigDecimal(monto));
			cuenta.setPersona(actual);
			assertNotNull(cuenta.getSaldo());
			assertNotNull(cuenta.getPersona());
			assertEquals(esperado,actual);
			assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
		}
	}
	
	
	@Tag("param")
	@ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
	@MethodSource("montoList") 
	void testDebitoCuentaMethodeSource( String monto) {
		cuenta.debito(new BigDecimal(monto));
		assertNotNull(cuenta.getSaldo());
		assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
	}
	
	static List<String> montoList(){
		return Arrays.asList("100", "200", "300", "500", "700", "1000");
	}
	
	@Nested
	@Tag("timeout")
	class EjemploTimeoutTest{
		
		@Test
		@Timeout(1)
		void pruebaTimeout() throws InterruptedException {
			TimeUnit.SECONDS.sleep(1);
		}
		
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		void pruebaTimeout2() throws InterruptedException {
			TimeUnit.MILLISECONDS.sleep(900); 
		}
		
		@Test
		void testTimeoutAssertions() {
			assertTimeout(Duration.ofSeconds(5), ()->{
				TimeUnit.MILLISECONDS.sleep(4000);
			});
		}
	}
	
}
