import java.util.*;


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

    void typeCheck(){
        if(this.op1 instanceof Integer && this.op2 instanceof Integer){
            this.i1 = (Integer) op1;
            this.i2 = (Integer) op2;
        } else if (this.op1 instanceof Integer && this.op2 instanceof Float){ 
            this.f1 = (Float) op1;
            this.f2 = (Float) op2;
        } else if (this.op1 instanceof Float && this.op2 instanceof Integer){
            this.f1 = (Float) op1;
            this.f2 = (Float) op2;
        } else {
            this.f1 = (Float) op1;
            this.f2 = (Float) op2;
        }
    }

    void operate(){
        if(i1 instanceof Integer){
            iresult = calculate(i1, i2);
        } else {
            fresult = calculate(f1, f2);
        }
    }
    
    Integer calculate(Integer one, Integer two){
        if(this.Id == 1){
            return one + two;
        } else if (this.Id == 2){
            return one - two;
        } else if (this.Id == 3){
            return one * two;
        } else {
            return one / two;
        }
    }

    Float calculate(Float one, Float two){
        if(this.Id == 1){
            return one + two;
        } else if(this.Id == 2){
            return one - two;
        } else if(this.Id ==3){
            return one * two;
        } else{
            return one / two;
        }
    }
}