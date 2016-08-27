package kr.ac.mashup.kongukongu.kongukongu.homespinner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by owner on 2016-08-27.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1;

    String firstItem = String.valueOf(spinner1.getSelectedItem());

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
            // ToDo when first item is selected
        } else {
            Toast.makeText(parent.getContext(),
                    "You have selected : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg) {

    }

}
