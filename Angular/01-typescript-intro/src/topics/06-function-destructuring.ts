export interface Product {
    description: string;
    price: number;
}

const phone: Product = {
    description: 'Nokia A1',
    price: 150.0
}

const tablet: Product = {
    description: 'iPad Air',
    price: 250.0
}

interface taxCalcultaionOptions{
    tax: number;
    products: Product[];
}


export function taxCalculation(options: taxCalcultaionOptions): [number, number]{ 
    let total=0;

   const {tax, products} = options;
   

    products.forEach(product =>{ //cambiar 'roduct por ({price})
        const {price} = product;
        total += price;
    })

    return [total, total*tax];
}

const shoppingCart = [phone, tablet];
const tax = 0.15;

const [total, taxCal] = taxCalculation({
    products: shoppingCart,
    tax, //no es necesario tax: tax, si tienen el mismo nombre
});

//console.log('Total:', total);
//console.log('Total:', taxCal);

