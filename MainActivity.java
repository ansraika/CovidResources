package in_.betasources.covidresources;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    CheckBox oxygen, ventilator,bed,icu,food,plasma,remdesivir,tocilizumab;
    TextView note;
    Button twitter;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.city);
        oxygen = findViewById(R.id.oxygen);
        ventilator = findViewById(R.id.ventilator);
        bed = findViewById(R.id.bed);
        icu = findViewById(R.id.icu);
        food = findViewById(R.id.food);
        plasma = findViewById(R.id.plasma);
        remdesivir = findViewById(R.id.remdesivir);
        tocilizumab = findViewById(R.id.tocilizumab);
        note = findViewById(R.id.note);
        twitter = findViewById(R.id.twitter);
        final String[] twitter_link = {"https://twitter.com/search?q=verified"};
        note.setText("Note:\n\n"+"\u2022  Please go through comments under tweet to check the authenticity.\n"+"\u2022  This app is not connected with any kind of information sources,it is just redirecting to the latest available information on twitter.\n"+
                "\u2022  Do not make any advance payment without getting confirmed and convinced by the lead.");
        twitter.setOnClickListener(v -> {
            String city = editText.getText().toString();
            if(city.isEmpty()){
                twitter_link[0] +=  " Nagpur (";
            }
            else{
                twitter_link[0] +=  " " + city +" (";
                if(oxygen.isChecked())
                    twitter_link[0] += " oxygen OR";

                if(ventilator.isChecked())
                    twitter_link[0] += " ventilator OR";

                if(bed.isChecked())
                    twitter_link[0] += " bed OR";

                if(icu.isChecked())
                    twitter_link[0] += " icu OR";

                if(food.isChecked())
                    twitter_link[0] += " food OR";

                if(plasma.isChecked())
                    twitter_link[0] += " plasma OR";

                if(remdesivir.isChecked())
                    twitter_link[0] += " remdesivir OR";

                if(tocilizumab.isChecked())
                    twitter_link[0] += " tocilizumab OR";
            }
            int length = twitter_link[0].length() - 2;
            twitter_link[0] = twitter_link[0].substring(0,length);
            twitter_link[0] += ")&f=live";
            Uri webpage = Uri.parse(twitter_link[0]);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            webIntent.setPackage("com.android.chrome");
            startActivity(webIntent);
            twitter_link[0] = "https://twitter.com/search?q=verified";
        });


    }


}