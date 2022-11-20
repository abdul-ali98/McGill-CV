package com.mcgill.mcgillcv;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mcgill.mcgillcv.controller.Generate;
import com.mcgill.mcgillcv.databinding.ActivityMainBinding;
import com.mcgill.mcgillcv.model.CV;
import com.mcgill.mcgillcv.model.Club;
import com.mcgill.mcgillcv.model.Experience;
import com.mcgill.mcgillcv.model.Language;
import com.mcgill.mcgillcv.model.Project;
import com.mcgill.mcgillcv.model.Sport;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private CV cv;
    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initCV();
    }

    private void initCV() {
        String name = "";
        String email = "";
        String phone = "";
        String website = "";
        String linkedIn = "";
        String github = "";
        String major = "";
        String minor = "";
        String gpa = "";
        String startYear = "";
        String graduationYear = "";
        cv = new CV(name, email, phone, website, linkedIn, github, major, minor, gpa, startYear, graduationYear);
        Log.d("reading file", Generate.createHTML(this.getApplicationContext(),cv));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void onCheckboxClicked(View v) {
    }
    public void firstSaveOnClick(View v) {
        boolean isCorrect = true;
        Editable name = ((EditText) findViewById(R.id.name)).getText();
        String regexName = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        if (name == null || !name.toString().matches(regexName) ) {
            Toast.makeText(this, "Name is Invalid, must start with Cap", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        else {
            cv.getBasicInformation().setName(name.toString());
        }
        Editable email = ((EditText) findViewById(R.id.email)).getText();
        String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (email == null || !email.toString().matches(regexEmail) ) {
            Toast.makeText(this, "Email is Invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        else {
            cv.getBasicInformation().setEmail(email.toString());
        }
        Editable phoneNumber = ((EditText) findViewById(R.id.phone)).getText();
        String regexPhone = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        if (phoneNumber == null || !phoneNumber.toString().matches(regexPhone) ) {
            Toast.makeText(this, "Phone is Invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        else {
            cv.getBasicInformation().setPhoneNumber(phoneNumber.toString());
        }
        Spinner majorSpinner = (Spinner) findViewById(R.id.major_spinner);
        String major = majorSpinner.getSelectedItem().toString();
        if (major.equals("Select your Major")) {
            Toast.makeText(this, "Major is not selected", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        else {
            cv.getBasicInformation().setMajor(major);
        }

        Spinner minorSpinner = (Spinner) findViewById(R.id.minor_spinner);
        String minor = majorSpinner.getSelectedItem().toString();
        if (!minor.equals("Select your Minor"))
            cv.getBasicInformation().setMajor(major);

        try {
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup_start);
            int radioButtonID = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
            String startYear = (String) radioButton.getText();
            cv.getBasicInformation().setStartDate(startYear);

            RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup_graduation);
            int radioButtonID2 = radioGroup2.getCheckedRadioButtonId();
            RadioButton radioButton2 = (RadioButton) radioGroup2.findViewById(radioButtonID2);
            String graduationtYear = (String) radioButton2.getText();
            cv.getBasicInformation().setExpectedGraduationDate(graduationtYear);
        }catch (Exception e) {
            Toast.makeText(this, "Please select start and expected graduation year", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }
        if (isCorrect)
            Toast.makeText(this, "saved!", Toast.LENGTH_SHORT).show();
    }

    public void secondSaveOnClick(View v){
        boolean isCorrect = true;
        Editable website = ((EditText) findViewById(R.id.website)).getText();
        String regexWebsite = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
        if (website == null || website.toString().length() < 10) {
       //     Toast.makeText(this, "Website is Invalid dude but I'll let it slide", Toast.LENGTH_LONG).show();
        }
        else {
            cv.getBasicInformation().setPersonalWebsite(website.toString());
        }
        Editable linkedIn = ((EditText) findViewById(R.id.linkedIn)).getText();
        if (linkedIn == null || linkedIn.toString().length() < 10 ) {
            Toast.makeText(this, "LinkedIn is Invalid, let it slide.. you should have one", Toast.LENGTH_LONG).show();
        }
        else {
            cv.getBasicInformation().setLinkedInLink(linkedIn.toString());
        }

        Editable gpa = ((EditText) findViewById(R.id.gpa)).getText();
        String regexGpa = "/^[0-4]\\.\\d\\d$/";
        if (gpa == null || gpa.toString().length() != 5 ) {
            Toast.makeText(this, "GPA is Invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        else {
            if (Double.valueOf(String.valueOf(gpa)) > 3.7)
                Toast.makeText(this, gpa.toString() +", You should go out and have fun more often, JK", Toast.LENGTH_LONG).show();
            cv.getBasicInformation().setGpa(gpa.toString());
        }
        CheckBox checkboxEnglish = (CheckBox) findViewById(R.id.checkbox_english);
        CheckBox checkboxFrench = (CheckBox) findViewById(R.id.checkbox_french);
        CheckBox checkboxJava = (CheckBox) findViewById(R.id.checkbox_java);

        if (!checkboxEnglish.isChecked() && !checkboxFrench.isChecked()){
            Toast.makeText(this, "Select a language, I can't let it slide.. sorry", Toast.LENGTH_LONG).show();
            isCorrect  = false;
        }
        if (checkboxJava.isChecked())
            Toast.makeText(this, "You still believe that Java is a spoken language?", Toast.LENGTH_LONG).show();
        if (checkboxEnglish.isChecked())
            cv.addLanguage(new Language("English",cv));
        if (checkboxFrench.isChecked())
            cv.addLanguage(new Language("French",cv));
        if (isCorrect) {
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void thirdSaveOnClick(View v) {
        boolean isCorrect = true;
        Editable title = ((EditText) findViewById(R.id.title_third)).getText();
        if (title == null || title.toString().length() < 5 || title.toString().length() > 30) {
            Toast.makeText(this, "Title is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        Editable company = ((EditText) findViewById(R.id.company_third)).getText();
        if (company == null || title.toString().length() < 2 || title.toString().length() > 30) {
            Toast.makeText(this, "Company is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }

        Editable startDate = ((EditText) findViewById(R.id.startDate_third)).getText();
        if (startDate == null || startDate.toString().length() != 7) {
            Toast.makeText(this, "start Date is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }

        Editable endDate = ((EditText) findViewById(R.id.endDate_third)).getText();
        if (endDate == null || endDate.toString().length() != 7) {
            Toast.makeText(this, "End Date is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }

        Editable description = ((EditText) findViewById(R.id.description_third)).getText();
        if (description == null || description.toString().length() > 200) {
            Toast.makeText(this, "description is invalid, max 200 char", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        String type = "";
        try {
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup_type);
            int radioButtonID = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
            type = (String) radioButton.getText();

        }catch (Exception e) {
            Toast.makeText(this, "Please select experience type", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }
        if (isCorrect) {
            Experience ex = new Experience(title.toString(), company.toString(),
                    startDate.toString(),endDate.toString(), description.toString(), Experience.ExperienceType.valueOf(type),cv);
            cv.addExperience(ex);
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
            emptyThird(null);
        }

    }
    public void emptyThird(View v) {
        ((EditText) findViewById(R.id.title_third)).setText("");
        ((EditText) findViewById(R.id.company_third)).setText("");
        ((EditText) findViewById(R.id.startDate_third)).setText("");
        ((EditText) findViewById(R.id.description_third)).setText("");
        ((EditText) findViewById(R.id.endDate_third)).setText("");
    }

    public void fourthSaveOnClick(View v) {

        boolean isCorrect = true;
        Editable title = ((EditText) findViewById(R.id.title_fourth)).getText();
        if (title == null || title.toString().length() < 2) {
            Toast.makeText(this, "Title is invalid", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }
        Editable description = ((EditText) findViewById(R.id.description_fourth)).getText();
        if (description == null || description.toString().length() < 30) {
            Toast.makeText(this, "Please provide more details", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }

        Editable url = ((EditText) findViewById(R.id.link_fourth)).getText();
        if (url == null || url.toString().length() != 7) {
            Toast.makeText(this, "url is invalid but will let it slide", Toast.LENGTH_LONG).show();
        }
        if (isCorrect) {
            Project p = new Project(title.toString(), description.toString(),url.toString(),cv);
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
            ((EditText) findViewById(R.id.title_fourth)).setText("");
            ((EditText) findViewById(R.id.description_fourth)).setText("");
            ((EditText) findViewById(R.id.link_fourth)).setText("");
        }
    }
    public void fifthSaveOnClick(View v){
        boolean isCorrect = true;
        Editable name = ((EditText) findViewById(R.id.club_fifth)).getText();
        if (name == null || name.toString().length() < 2) {
            Toast.makeText(this, "Club is invalid", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }
        Editable title = ((EditText) findViewById(R.id.title_fifth)).getText();
        if (title == null || title.toString().length() < 5) {
            Toast.makeText(this, "Invalid title/position", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }

        Editable description = ((EditText) findViewById(R.id.description_fifth)).getText();
        if (description == null || description.toString().length() < 30) {
            Toast.makeText(this, "Please provide more details", Toast.LENGTH_LONG).show();
            isCorrect = false;
        }
        if (isCorrect) {
            Club club = new Club(name.toString(), title.toString(), description.toString(),cv);
            cv.addClub(club);
            ((EditText) findViewById(R.id.club_fifth)).setText("");
            ((EditText) findViewById(R.id.title_fifth)).setText("");
            ((EditText) findViewById(R.id.description_fifth)).setText("");
        }

    }
    public void sixthSaveOnClick(View v) {
        boolean isCorrect = true;
        Editable name = ((EditText) findViewById(R.id.team_name_sixth)).getText();
        if (name == null || name.toString().length() < 2) {
            Toast.makeText(this, "Team name is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        Editable sportName = ((EditText) findViewById(R.id.sport_sixth)).getText();
        if (sportName == null || sportName.toString().length() < 5) {
            Toast.makeText(this, "Invalid Sport", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }

        Editable startDate = ((EditText) findViewById(R.id.start_date_sixth)).getText();
        if (startDate == null || startDate.toString().length() != 7) {
            Toast.makeText(this, "start date is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        Editable endDate = ((EditText) findViewById(R.id.end_date_sixth)).getText();
        if (startDate == null || startDate.toString().length() != 7) {
            Toast.makeText(this, "End date is invalid", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        if (isCorrect) {
            Sport sport = new Sport(name.toString(),name.toString(),startDate.toString(),endDate.toString(),cv);
            cv.addSport(sport);
            ((EditText) findViewById(R.id.team_name_sixth)).setText("");
            ((EditText) findViewById(R.id.sport_sixth)).setText("");
            ((EditText) findViewById(R.id.start_date_sixth)).setText("");
            ((EditText) findViewById(R.id.end_date_sixth)).setText("");
        }

    }
    public void seventhSaveOnClick(View v) {
        CheckBox checkboxComp202 = (CheckBox) findViewById(R.id.checkbox_comp202);
        CheckBox checkboxComp206 = (CheckBox) findViewById(R.id.checkbox_comp206);
        CheckBox checkboxECSE202 = (CheckBox) findViewById(R.id.checkbox_ecse202);
        CheckBox checkboxComp250 = (CheckBox) findViewById(R.id.checkbox_comp250);
        CheckBox checkboxComp251 = (CheckBox) findViewById(R.id.checkbox_comp251);
        CheckBox checkboxComp302 = (CheckBox) findViewById(R.id.checkbox_comp302);
        CheckBox checkboxECSE324 = (CheckBox) findViewById(R.id.checkbox_ecse324);
        CheckBox checkboxECSE223 = (CheckBox) findViewById(R.id.checkbox_ecse223);
        CheckBox checkboxECSE321 = (CheckBox) findViewById(R.id.checkbox_ecse321);
        if(checkboxComp202.isChecked())
            cv.addCourse("COMP202");
        if(checkboxComp206.isChecked())
            cv.addCourse("COMP206");
        if(checkboxComp250.isChecked())
            cv.addCourse("COMP250");
        if(checkboxComp251.isChecked())
            cv.addCourse("COMP251");
        if(checkboxComp302.isChecked())
            cv.addCourse("COMP302");
        if(checkboxECSE202.isChecked())
            cv.addCourse("ECSE202");
        if(checkboxECSE324.isChecked())
            cv.addCourse("ECSE324");
        if(checkboxECSE223.isChecked())
            cv.addCourse("ECSE223");
        if(checkboxECSE321.isChecked())
            cv.addCourse("ECSE321");
        if (cv.getCourses().size() < 1)
            Toast.makeText(this,"You only took " + cv.getCourses().size()+ " courses", Toast.LENGTH_LONG ).show();

        try {
            String output=  Generate.createHTML(this.getApplicationContext(), cv);
            Log.d("Generate: ", output);
            WebView webView = (WebView) findViewById(R.id.webview_seventh);
            webView.setVisibility(View.VISIBLE);
            checkboxComp202.setVisibility(View.GONE);
            checkboxComp206 .setVisibility(View.GONE);
            checkboxECSE202 .setVisibility(View.GONE);
            checkboxComp250 .setVisibility(View.GONE);
            checkboxComp251 .setVisibility(View.GONE);
            checkboxComp302 .setVisibility(View.GONE);
            checkboxECSE324 .setVisibility(View.GONE);
            checkboxECSE223.setVisibility(View.GONE);
            checkboxECSE321.setVisibility(View.GONE);
            findViewById(R.id.textview_seventh).setVisibility(View.GONE);
            findViewById(R.id.seventh_save).setVisibility(View.GONE);
            findViewById(R.id.button_seventh_previous).setVisibility(View.GONE);
            webView.loadDataWithBaseURL("",output, "text/html", "UTF-8", "" );
        } catch (Exception e) {
            e.getMessage();
            Log.d("error motherfucker", e.getMessage());
        }
    }
    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("cv.html", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}