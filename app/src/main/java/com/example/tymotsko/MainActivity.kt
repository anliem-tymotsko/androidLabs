package com.example.tymotsko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.tymotsko.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_1.*


class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        // prevent nav gesture if not on start destination
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    /* val formate = SimpleDateFormat("dd MMM, YYYY", Locale.US)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         btn_date.setOnClickListener {
             val now = Calendar.getInstance()
             val datePicker = DatePickerDialog(
                 this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                     val selectedDate = Calendar.getInstance()
                     selectedDate.set(Calendar.YEAR, i)
                     selectedDate.set(Calendar.MONTH, i2)
                     selectedDate.set(Calendar.DAY_OF_MONTH, i3)
                     val date = formate.format(selectedDate.time)
                     Toast.makeText(
                         this,
                         "Year : " + i + "\nMonth: " + i2 + "\nDate: " + i3,
                         Toast.LENGTH_SHORT
                     ).show()
                 },
                 now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
             )
             datePicker.show()
         }

         btn_time.setOnClickListener {
             val now = Calendar.getInstance()
             val timePicker =
                 TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                     Toast.makeText(this, "time :" + i + " : " + i2, Toast.LENGTH_SHORT).show()
                 }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false)
             timePicker.show()

         }

         btn_activity2.setOnClickListener {
             val intent = Intent(this, SecondActivity::class.java)
             startActivity(intent)
         }

     }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.main, menu);
         return super.onCreateOptionsMenu(menu)
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         var selectedOption = "";
         when (item?.itemId) {
             R.id.aboutid -> selectedOption = "About";
             R.id.usageis -> selectedOption = "Usage";

         }
         if (selectedOption == "About") {
             Toast.makeText(
                 this,
                 "this is app to book our restaurant from home. You can choose dishes, portions and other details to make your dinner enjoyable",
                 Toast.LENGTH_LONG
             ).show();
         } else if (selectedOption == "Usage") {
             Toast.makeText(
                 this,
                 "Conditions are intended to promote the licensing objectives:\n" +
                         "\n" +
                         "the prevention of crime and disorder\n" +
                         "public safety\n" +
                         "the prevention of public nuisance; and\n" +
                         "the protection of children from harm.\n" +
                         "Conditions can be suggested by premises owners, or sought by interested parties such as residents and required by responsible authorities such as the police. Conditions must be applied on a case-by-case basis.",
                 Toast.LENGTH_LONG
             ).show();

         }
         return super.onOptionsItemSelected(item)
     }

     val NAME = "NAME"

     fun onButtonClick(view: View) {

         startActivity(intent)
     }*/
}