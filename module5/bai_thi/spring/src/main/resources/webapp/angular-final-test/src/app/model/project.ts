export class Project {
  private _id: number;
  private _nameStudent: string;
  private _nameGroup: string;
  private _nameProject: string;
  private _nameTeacher: string;
  private _email: string;
  private _phone: string;


  constructor(id: number, nameStudent: string, nameGroup: string, nameProject: string, nameTeacher: string, email: string, phone: string) {
    this._id = id;
    this._nameStudent = nameStudent;
    this._nameGroup = nameGroup;
    this._nameProject = nameProject;
    this._nameTeacher = nameTeacher;
    this._email = email;
    this._phone = phone;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nameStudent(): string {
    return this._nameStudent;
  }

  set nameStudent(value: string) {
    this._nameStudent = value;
  }

  get nameGroup(): string {
    return this._nameGroup;
  }

  set nameGroup(value: string) {
    this._nameGroup = value;
  }

  get nameProject(): string {
    return this._nameProject;
  }

  set nameProject(value: string) {
    this._nameProject = value;
  }

  get nameTeacher(): string {
    return this._nameTeacher;
  }

  set nameTeacher(value: string) {
    this._nameTeacher = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }
}
