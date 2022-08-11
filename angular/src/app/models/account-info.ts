import { TransactionDTO } from "./transaction-dto";

export interface AccountInfo {
    customerId: String;
    accountId: Number;
    balance: Number;
    transactionDTOList : TransactionDTO[];
}
