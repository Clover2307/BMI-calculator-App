package com.example.a1cet3013n

class CalculationBMI {

    companion object {
        fun bmiValues(unit: String, weight: Float, height: Float): Float {
            return if (unit == "Metric (kg,cm)") {
                val heightM = height/100 //convert cm to m
                weight/(heightM * heightM)
            } else {
                703 *(weight/(height * height))
            }
        }

        fun bmiStatus(bmi : Float, age:Int, gender: String): String{
            return if(age>=21){
                getCategoryAdult(bmi)
            }else{
                getCategoryChild(bmi, gender, age)
            }
        }

        fun getCategoryAdult(bmi: Float): String{
            return when {
                bmi < 15 -> "Very severely underweight"
                bmi>=15 && bmi<16 -> "Severely underweight"
                bmi >=16 && bmi<18.5 -> "Underweight"
                bmi >=18.5 && bmi<25 -> "Normal (healthy weight)"
                bmi >=25 && bmi<30 -> "Overweight"
                bmi >=30 && bmi<35 -> "Mode Moderately"
                bmi >=35 && bmi<40 -> "Severely obese"
                else -> "Very severely obese"
            }
        }

        fun getCategoryChild(bmi:Float, gender:String, age:Int): String{
           val bmiCat: Array<Float> = if (gender=="Female"){ //if gender = female
               when(age){
                   2-> arrayOf(14.8f, 18.2f,19.4f)
                   3->arrayOf(13.0f, 17.0f, 18.3f)
                   4->arrayOf(13.7f, 16.8f, 18.0f)
                   5->arrayOf(13.5f,16.8f,18.2f)
                   6->arrayOf(13.4f,17.1f,18.3f)
                   7->arrayOf(13.4f,17.6f,19.6f)
                   8->arrayOf(13.5f,18.3f,20.6f)
                   9->arrayOf(13.8f,19.0f,21.8f)
                   10->arrayOf(14.0f,19.9f,22.9f)
                   11->arrayOf(14.4f,20.8f,24.1f)
                   12->arrayOf(14.8f,21.7f,25.2f)
                   13->arrayOf(15.3f,22.5f,26.2f)
                   14->arrayOf(15.8f,23.3f,27.2f)
                   15->arrayOf(16.3f,24.0f,28.1f)
                   16->arrayOf(16.8f,24.6f,28.9f)
                   17->arrayOf(17.2f,25.2f,29.6f)
                   18->arrayOf(17.6f,25.7f,30.3f)
                   19->arrayOf(17.8f,26.1f,31.0f)
                   20->arrayOf(17.8f,26.5f,31.8f)
                   else->arrayOf()
               }
           }else{ //gender male
               when (age){
                   2-> arrayOf(14.8f,18.2f,19.4f)
                   3->arrayOf(14.3f,17.3f,18.3f)
                   4->arrayOf(14.0f,16.9f,17.8f)
                   5->arrayOf(13.9f,16.8f,17.9f)
                   6->arrayOf(13.7f,17.0f,18.4f)
                   7->arrayOf(13.7f,17.4f,19.1f)
                   8->arrayOf(13.8f,17.9f,19.5f)
                   9->arrayOf(14.0f,18.6f,21.0f)
                   10->arrayOf(14.2f,19.4f,22.1f)
                   11->arrayOf(14.5f,20.2f,23.2f)
                   12->arrayOf(15.0f,21.0f,24.2f)
                   13->arrayOf(15.4f,21.8f,25.1f)
                   14->arrayOf(16.0f,22.6f,26.0f)
                   15->arrayOf(16.5f,23.4f,26.8f)
                   16->arrayOf(17.1f,24.2f,27.5f)
                   17->arrayOf(17.6f,24.9f,28.2f)
                   18->arrayOf(18.2f,25.6f,28.9f)
                   19->arrayOf(18.7f,26.3f,29.7f)
                   20->arrayOf(19.1f,27.0f,30.6f)
                   //age from 2 until 20
                   else->arrayOf()
               }
           }
            return when{
                bmi< bmiCat[0] -> "Underweight"
                bmi>= bmiCat[0] && bmi<=bmiCat[1] ->"Healthy Weight"
                bmi>bmiCat[1] && bmi<=bmiCat[2]-> "Overweight"
                else->"Obesity"
            }
        }
}
}