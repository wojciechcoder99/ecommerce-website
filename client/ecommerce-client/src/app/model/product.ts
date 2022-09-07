export class Product {
    constructor(public id: number,
        public name: string,
        public description: string,
        public price: number,
        public quantity: number,
        public active: boolean,
        public created: Date,
        public updated: Date
    ) { }
}