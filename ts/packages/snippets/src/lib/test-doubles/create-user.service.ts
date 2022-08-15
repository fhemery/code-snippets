import {v4 as uuidV4} from 'uuid';

export class User {
    constructor(readonly id: string, readonly name: string, readonly email: any) {
    }
}

export interface IUserRepository {
    insert(name: string, email: string): string;
    get(id: string): User | null;
}

export class UserRepository implements IUserRepository {
    constructor (private db: any){}

    insert(name: string, email: string): string {
        const id = uuidV4();
        this.db.insert(new User(id, name, email));
        return id;
    }

    get(id: string): User | null {
      return this.db.get(id);
    }
}

export class UserValidationService {
    sendActivationLinkToUser(id: string): void {}
}

export class NotificationService {
    sendNotification(to: string, message: string): void {}
}

export class CreateUserService {
    constructor(private userRepository: IUserRepository, private userValidationService: UserValidationService, private notificationService: NotificationService) {}

    createUser(name: string, email: string) : string {
        const id = this.userRepository.insert(name, email);
        this.userValidationService.sendActivationLinkToUser(id);
        return id;
    }
}
