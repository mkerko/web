export class User {
    id: string;
    email: string;
    password: string;
    name: string;
    surname: string;
    faculty: string;
    course: number;
    group: number;

    constructor( id: string,
        email: string,
        password: string,
        name: string,
        surname: string,
        faculty: string,
        course: number,
        group: number) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.name = name;
            this.surname = surname;
            this.faculty = faculty;
            this.course = course;
            this.group = group;
        }
}
