package Algorithms.Math;

public class NumberValid {
    enum STATE {
        START, INTEGER, DECIMAL, UNKNOWN, AFTERDECIMAL
    };

    static STATE getNextState(STATE currentState, char ch) {
        if(currentState == STATE.START || currentState == STATE.INTEGER){
            if(ch == '.'){
                return STATE.DECIMAL;
            }

            else if(ch >= '0' && ch <= '9'){
                return STATE.INTEGER;
            }

            else{
                return STATE.UNKNOWN;
            }
        }
    
        if(currentState == STATE.DECIMAL){
            if(ch >= '0' && ch <= '9'){
                return STATE.AFTERDECIMAL;
            }

            else {
                return STATE.UNKNOWN;
            }
        }

        if(currentState == STATE.AFTERDECIMAL){
            if(ch >= '0' && ch <= '9'){
                return STATE.AFTERDECIMAL;
            }

            else{
                return STATE.UNKNOWN;
            }
        }

        return STATE.UNKNOWN;
    }

    static boolean isNumberValid(String s){
        if(s.isEmpty()){
            return true;
        }

        int i = 0;

        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            i++;
        }

        STATE currentState = STATE.START;

        for(; i < s.length(); i++){
            currentState = getNextState(currentState, s.charAt(i));

            if(currentState == STATE.UNKNOWN){
                return false;
            }
        }

        if(currentState == STATE.DECIMAL){
            return false;
        }
        return true;
    }
}
