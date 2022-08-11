import { AccountInfo } from "./account-info";

export interface UserInformation {
    name:String;
    surname:String;
    initialCredit:Number;
    accountInfos:AccountInfo[];
}
