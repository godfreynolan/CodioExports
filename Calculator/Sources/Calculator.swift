class Calculator {
    private(set) var total = 0;
    
    func add(amount:Int) {
        total += amount;
    }
    
    func subtract(amount:Int) {
        total -= amount;
    }
    
    func multiply(amount:Int) {
        total = total * amount;
    }
    
    func divide(amount:Int) {
        total = total/amount;
    }
}