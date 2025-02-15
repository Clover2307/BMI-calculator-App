package com.example.a1cet3013n

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.a1cet3013n.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:BMI
    var bmi : Float = 0.0f
    var bmiS: String =""
    var color = 0
    var image = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup toolbar
        setSupportActionBar(binding.toolbar)

        //view model object
        viewModel = ViewModelProvider(this).get(BMI:: class.java)

        //action button calculate
        binding.buttonCalculate.setOnClickListener {

            //get user weight, height, and age
            val unit:String = binding.spinnerUnits.selectedItem.toString()
            val gender:String = binding.spinnerGender.selectedItem.toString()
            val userInput: String? = binding.textHeight.text?.toString()
            val userHeight: Float? = userInput?.toFloatOrNull()
            val userWeight:Float? = binding.textWeight.text.toString().toFloatOrNull()
            val userAge:Int? = binding.textAge.text.toString().toIntOrNull()

            //declare error message
            val error = "Please fill up all the fields with numeric values!"
            val error2  = "Your age should be more than 0!"

            if(userWeight==null){
                binding.textWeight.error = error
                return@setOnClickListener
            }

            if(userHeight==null){
                binding.textHeight.error = error
                return@setOnClickListener
            }

            if(userAge==null){
                binding.textAge.error = error
                return@setOnClickListener
            }

            if(userAge<0){
                binding.textAge.error = error2
            }

            if(unit==("--Select Here--")){
                Toast.makeText(this, "Please select a unit! metric(kg,cm), imperial(lbs,inc)",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(gender==("--Select Here--")){
                Toast.makeText(this, "Please select a gender",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //get the bmi values, and categories by passing parameters to another class
            bmi = CalculationBMI.bmiValues(unit, userWeight, userHeight)
            bmiS = CalculationBMI.bmiStatus(bmi,userAge, gender)

            //pass parameter another class to assign color and image for each category
            val colorAndImage = ColorImage.colorWithImage(bmiS)
            color = colorAndImage[0] //get the color from the another class
            image= colorAndImage[1] //get the image from the another class


            //set the color for difference categories
            binding.textBmiValues.setTextColor(ContextCompat.getColor(this, color))
            binding.textBmiMessage.setTextColor(ContextCompat.getColor(this, color))
            //set the image for different categories
            binding.imageIcon.setImageResource(image)
            //show the bmi values, and bmi categories
            binding.textBmiValues.text = String.format("%.1f", bmi)
            binding.textBmiMessage.text = bmiS

        }

        //action button clear
        binding.buttonClear?.setOnClickListener {
            binding.textWeight.setText("")
            binding.textHeight.setText("")
            binding.textAge.setText("")
            binding.textBmiValues.text =""
            binding.textBmiMessage.text=""
            binding.imageIcon.setImageResource(0)
            binding.spinnerGender.setSelection(0)
            binding.spinnerUnits.setSelection(0)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_about->{
                val aboutDialog = AboutDialog() // create the dialog object

                //show the dialog as a fragment type
                //if the dialog is shown in fragment, it will retain in the memory
                aboutDialog.show(supportFragmentManager,"123")
            }
            R.id.item_formula->{
                val formulaDialog = CalDialog()
                formulaDialog.show(supportFragmentManager,"123")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        //save the bmi and status to view object
        viewModel.bmiValues = binding.textBmiValues.text.toString().format("%.1f", bmi)
        viewModel.bmiStatus = binding.textBmiMessage.text.toString()
        viewModel.color= binding.textBmiMessage.currentTextColor
        viewModel.image= image
    }

    override fun onResume() {
        super.onResume()
        //restore the data
        binding.textBmiValues.text = viewModel.bmiValues
        binding.textBmiMessage.text = viewModel.bmiStatus
        binding.textBmiValues.setTextColor(viewModel.color)
        binding.textBmiMessage.setTextColor( viewModel.color)
        // Restore the image resource
        binding.imageIcon.setImageResource(viewModel.image)
    }
}