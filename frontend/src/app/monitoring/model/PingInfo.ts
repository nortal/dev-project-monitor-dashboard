export class PingInfo {
    constructor(
        public id: number,
        public module: string,
        public status:string,
        public statusDetail:string,
        public url:string,
        public checked:Date,
        public lastResponded:Date
    ){}
}