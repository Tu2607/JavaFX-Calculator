interface devOp <T> {
    T getValue();
}

class operation <T> implements devOp <T> {
    T op1;
    Integer Id;    

    operation(T num1, Integer id){
        this.op1 = num1;
        this.Id = id;
    }

    public T getValue(){
        return this.op1;
    }
}

class answer <Y, T> extends operation<T> {

    Y op2;

    Float f1, f2, fresult;
    Integer i1, i2, iresult;

    answer(Y num, operation<T> op){
        super(op.op1, op.Id);
        this.op2 = num;
        f1 = null;
        f2 = null;
        fresult = null;
        i1 = null;
        i2 = null;
        iresult = null;
    }

    void typeCheck(){ //Error in here. Check your type Cast
        if(this.op1 instanceof Integer && this.op2 instanceof Integer){
            this.i1 = (Integer) op1;
            this.i2 = (Integer) op2;
        } else if (this.op1 instanceof Integer && this.op2 instanceof Float){ 
            Integer temp = (Integer) this.op1;
            this.f1 = temp.floatValue();
            this.f2 = (Float) op2;
        } else if (this.op1 instanceof Float && this.op2 instanceof Integer){
            Integer temp = (Integer) this.op2;
            this.f1 = (Float) op1;
            this.f2 = temp.floatValue();
        } else {
            this.f1 = (Float) op1;
            this.f2 = (Float) op2;
        }
    }

    void operate(){
        if(i1 instanceof Integer){
            calculate(i1, i2);
        } else {
            calculate(f1, f2);
        }
    }
    
    void calculate(Integer one, Integer two){
        if(this.Id == 1){
            this.iresult =  one + two;
        } else if (this.Id == 2){
            this.iresult =  one - two;
        } else if (this.Id == 3){
            this.iresult =  one * two;
        } else if (this.Id == 4) { //A check for division
            if((one.floatValue()/two.floatValue()) % 1 == 0) { //This is a whole number
                this.iresult = one / two;
            } else {
                this.fresult = one.floatValue() / two.floatValue();
            }
        } else {
            this.iresult =  one % two;
        }
    }

    void calculate(Float one, Float two){
        if(this.Id == 1){
            this.fresult = one + two;
        } else if(this.Id == 2){
            this.fresult = one - two;
        } else if(this.Id == 3){
            this.fresult =  one * two;
        } else if (this.Id == 4){
            this.fresult =  one / two;
        } else {
            this.fresult =  one % two;
        }
    }
}