interface BankAccount{
    void deposit(float amount);
    void withdraw(float amount);
    void getBalance();
}

class Account implements BankAccount{
    private String name;
    private int accNo;
    private float balance;

    Account(){
        this.name = "Test";
        this.accNo = 0;
        this.balance = 0;
    }

    Account(String name, int accNo, float balance){
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void deposit(float amount){
        balance += amount;
        System.out.println("Deposit: " + amount);
    }

    public void withdraw(float amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public void getBalance(){
        System.out.println("Balance: " + balance);
    }

    @Override
    public String toString(){
        return "AccName: "+ name + "\nAccNo: " + accNo + "\nBalance: " + balance;
    }
}

