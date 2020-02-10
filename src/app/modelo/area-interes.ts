import { Usuario } from './usuario';

export class AreaInteres {
    public id:number;
    constructor(
        public nombre:string,
        public descripcion:string,
        public fechacreacion:Date){}
}
