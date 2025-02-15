package com.example.a1cet3013n

class ColorImage {

    companion object{
        fun colorWithImage(bmiCategory: String):IntArray{
            val ciResult = IntArray(2)

            //assign different color and image for each categories
            when (bmiCategory) {
                "Very severely underweight" -> {
                    ciResult[0] = R.color.very_sev_underweight
                    ciResult[1] =R.drawable.very_seve_underweight
                }
                "Severely underweight" -> {
                    ciResult[0] = R.color.sev_underweight
                    ciResult[1] =R.drawable.seve_underweight
                }
                "Underweight" -> {
                    ciResult[0] = R.color.under_weight
                    ciResult[1]=R.drawable.underweight
                }
                "Normal (healthy weight)", "Healthy Weight" -> {
                    ciResult[0] = R.color.healthy_weight
                    ciResult[1] = R.drawable.normalweight
                }
                "Overweight" -> {
                    ciResult[0] = R.color.over_weight
                    ciResult[1] = R.drawable.overweight
                }
                "Mode Moderately" -> {
                    ciResult[0] = R.color.mode_moderately
                    ciResult[1] = R.drawable.mode_obese
                }
                "Severely obese" -> {
                    ciResult[0] = R.color.sev_obese
                    ciResult[1] = R.drawable.seve_obese
                }
                //bmiS=="Very severely obese" || bmiS=="Obesity"->color = R.color.obese
                else -> {
                    ciResult[0]=R.color.obese
                    ciResult[1] = R.drawable.obese
                }
            }
            return ciResult
        }
    }
}