package my.edu.tarc.loanapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.edu.tarc.loanapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCalculate.setOnClickListener {
            //TODO: Get inputs from user and calculate the monthly payment
            if (binding.editTextPrice.text.isEmpty()) {
                binding.editTextPrice.error = "Value required" //getString(R.string.error_input)
                return@setOnClickListener
            }
            val price: Int = Integer.parseInt(binding.editTextPrice.text.toString())
            val downPayment: Int = Integer.parseInt(binding.editTextDownPayment.text.toString())
            val interestRate: Double = binding.editTextInterestRate.text.toString().toDouble()
            val year: Int = binding.spinnerYear.selectedItemPosition + 3


            val loanAmount: Int = price - downPayment
            val interest: Double = loanAmount * interestRate * year

            // calculate the monthly payment and display
            val monthlyPay: Double = (loanAmount + interest) / year / 12
            binding.textViewPayment.text = "$monthlyPay"

        }

        binding.buttonReset.setOnClickListener {
            //TODO: Reset all views and output
            binding.editTextPrice.text.clear()
            binding.editTextDownPayment.text.clear()
            binding.editTextInterestRate.text.clear()
            binding.spinnerYear.setSelection(0)
            binding.textViewPayment.text = null
        }
    }
}