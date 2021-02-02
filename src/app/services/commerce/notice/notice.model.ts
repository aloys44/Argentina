
export class Notice {
    id: number;
    note: number;
    comment: string;
    user: number

    constructor(id: number, note: number, comment: string, user: number) {
        this.id = id;
        this.note = note;
        this.comment = comment;
        this.user = user;

    }
}