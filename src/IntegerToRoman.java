class IntegerToRoman {
    private String performOperation(int digit, String lessThanFour, String five, String nine){
        String roman = "";
        if(digit < 4){
            for(int i  = 0; i < digit; i++){
                roman = roman + lessThanFour;
            }
        }
        else if(digit == 5){
            roman = five;
        }
        else if(digit == 4){
            roman = lessThanFour + five;
        }
        else if(digit > 5 && digit < 9){
            roman = five;
            int diff = digit - 5;
            for(int i  = 0; i < diff; i++){
                roman = roman + lessThanFour;
            }
        }
        else{
            roman = lessThanFour + nine;
        }
        return roman;
    }

    public String intToRoman(int num) {
        String roman = "";
        String temp = "";
        String number = new Integer(num).toString();
        int place = 1;
        for(int i = number.length()-1; i >= 0; i--){
            int digit = number.charAt(i) - '0';
            if(place == 1){
                temp = performOperation(digit, "I","V", "X");
                roman = temp + roman;
            }
            else if(place == 10){
                temp = performOperation(digit, "X","L", "C");
                roman = temp + roman;
            }
            else if(place == 100){
                temp = performOperation(digit, "C","D", "M");
                roman = temp + roman;
            }
            else if(place == 1000){
                temp = "";
                for(int k  = 0; k < digit; k++){
                    temp = temp + "M";
                }
                roman = temp + roman;
            }
            place *= 10;
        }
        return roman;
    }
}