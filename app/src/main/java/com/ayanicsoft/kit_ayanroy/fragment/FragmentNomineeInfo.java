package com.ayanicsoft.kit_ayanroy.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ayanicsoft.kit_ayanroy.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentNomineeInfo extends Fragment {

    View layoutNominee1, layoutNominee2, layoutNominee3, layoutNominee4, layoutNominee5;
    RadioButton radioBtnAppointNominee_yes, radioBtnAppointNominee_no, btnN1_canWrite_yes,
            btnN1_canWrite_no, btnN2_canWrite_yes, btnN2_canWrite_no;
    MaterialButton btnAddMoreNominee;
    LinearLayout layoutSpecificReason;
    TextInputLayout layoutWhyNot, layoutN1_otherOccu, layoutN2_otherOccu;
    AutoCompleteTextView cmbWhyNot, cmbN1_relationship, cmbN1_gender, cmbN1_occupation, cmbN2_relationship, cmbN2_gender, cmbN2_occupation;
    TextInputEditText tvSpecificReason, tvN1_fName, tvN1_mName, tvN1_lName, tvN1_age, tvN1_otherOccupation,
            tvN2_fName, tvN2_mName, tvN2_lName, tvN2_age, tvN2_otherOccupation;

    TextInputEditText tvN3_name, tvN3_age, tvN3_otherOccupation;
    AutoCompleteTextView cmbN3_relation, cmbN3_gender, cmbN3_occupation;
    LinearLayout layoutN3_otherOccu;
    RadioButton btnN3_canWrite_yes, btnN3_canWrite_no;
    ImageView n3BtnClose;

    TextInputEditText tvN4_name, tvN4_age, tvN4_otherOccupation;
    AutoCompleteTextView cmbN4_relation, cmbN4_gender, cmbN4_occupation;
    LinearLayout layoutN4_otherOccu;
    RadioButton btnN4_canWrite_yes, btnN4_canWrite_no;
    ImageView n4BtnClose;

    TextInputEditText tvN5_name, tvN5_age, tvN5_otherOccupation;
    AutoCompleteTextView cmbN5_relation, cmbN5_gender, cmbN5_occupation;
    LinearLayout layoutN5_otherOccu;
    RadioButton btnN5_canWrite_yes, btnN5_canWrite_no;
    ImageView n5BtnClose;
    ArrayList<String> listReasonWhyNot;
    ArrayList<String> listNomineeRelationship;
    ArrayList<String> listNomineeGender;
    ArrayList<String> listNomineeOccupation;
    Context context;
    private static int numOfNominee = 0;
    private static boolean hasNominee = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nominee_info, container, false);
        context = getContext();

        layoutNominee1 = view.findViewById(R.id.layout_nominee_1);
        layoutNominee2 = view.findViewById(R.id.layout_nominee_2);
        layoutNominee3 = view.findViewById(R.id.layout_nominee_3);
        layoutNominee4 = view.findViewById(R.id.layout_nominee_4);
        layoutNominee5 = view.findViewById(R.id.layout_nominee_5);

        radioBtnAppointNominee_yes = view.findViewById(R.id.btn_include_nominee_yes);
        radioBtnAppointNominee_no = view.findViewById(R.id.btn_include_nominee_no);
        layoutWhyNot = view.findViewById(R.id.layout_why_not);
        cmbWhyNot = view.findViewById(R.id.tv_why_not);
        layoutSpecificReason = view.findViewById(R.id.layout_specific_reason);
        tvSpecificReason = view.findViewById(R.id.tv_specific_reason);
        btnAddMoreNominee = view.findViewById(R.id.btn_add_more_nominee);


        /**     Hooks for Nominee 1     */
        tvN1_fName = view.findViewById(R.id.tv_n1_fName);
        tvN1_mName = view.findViewById(R.id.tv_n1_mName);
        tvN1_lName = view.findViewById(R.id.tv_n1_lName);
        cmbN1_relationship = view.findViewById(R.id.cmb_n1_relationship);
        tvN1_age = view.findViewById(R.id.tv_n1_age);
        cmbN1_gender = view.findViewById(R.id.cmb_n1_gender);
        btnN1_canWrite_yes = view.findViewById(R.id.btn_n1_write_yes);
        btnN1_canWrite_no = view.findViewById(R.id.btn_n1_write_no);
        cmbN1_occupation = view.findViewById(R.id.cmb_n1_occupation);
        layoutN1_otherOccu = view.findViewById(R.id.layout_n1_other_occupation);

        /**     Hooks for Nominee 2     */
        tvN2_fName = view.findViewById(R.id.tv_n2_fName);
        tvN2_mName = view.findViewById(R.id.tv_n2_mName);
        tvN2_lName = view.findViewById(R.id.tv_n2_lName);
        cmbN2_relationship = view.findViewById(R.id.cmb_n2_relationship);
        tvN2_age = view.findViewById(R.id.tv_n2_age);
        cmbN2_gender = view.findViewById(R.id.cmb_n2_gender);
        btnN2_canWrite_yes = view.findViewById(R.id.btn_n2_write_yes);
        btnN2_canWrite_no = view.findViewById(R.id.btn_n2_write_no);
        cmbN2_occupation = view.findViewById(R.id.cmb_n2_occupation);
        layoutN2_otherOccu = view.findViewById(R.id.layout_n2_other_occupation);



        /**     Hooks for Nominee 3     */
        tvN3_name = view.findViewById(R.id.tv_n3_Name);
        tvN3_age = view.findViewById(R.id.tv_n3_age);
        tvN3_otherOccupation = view.findViewById(R.id.tv_n3_other_occupation);
        cmbN3_gender = view.findViewById(R.id.cmb_n3_gender);
        cmbN3_relation = view.findViewById(R.id.cmb_n3_relationship);
        cmbN3_occupation = view.findViewById(R.id.cmb_n3_occupation);
        btnN3_canWrite_yes = view.findViewById(R.id.btn_n3_write_yes);
        btnN3_canWrite_no = view.findViewById(R.id.btn_n3_write_no);
        layoutN3_otherOccu = view.findViewById(R.id.layout_n3_other_occupation);
        n3BtnClose = view.findViewById(R.id.btn_n3_close);


        /**     Hooks for Nominee 4     */
        tvN4_name = view.findViewById(R.id.tv_n4_Name);
        tvN4_age = view.findViewById(R.id.tv_n3_age);
        tvN4_otherOccupation = view.findViewById(R.id.tv_n4_other_occupation);
        cmbN4_gender = view.findViewById(R.id.cmb_n4_gender);
        cmbN4_relation = view.findViewById(R.id.cmb_n4_relationship);
        cmbN4_occupation = view.findViewById(R.id.cmb_n4_occupation);
        btnN4_canWrite_yes = view.findViewById(R.id.btn_n4_write_yes);
        btnN4_canWrite_no = view.findViewById(R.id.btn_n4_write_no);
        layoutN4_otherOccu = view.findViewById(R.id.layout_n4_other_occupation);
        n4BtnClose = view.findViewById(R.id.btn_n4_close);

        /**     Hooks for Nominee 5     */
        tvN5_name = view.findViewById(R.id.tv_n5_Name);
        tvN5_age = view.findViewById(R.id.tv_n3_age);
        tvN5_otherOccupation = view.findViewById(R.id.tv_n5_other_occupation);
        cmbN5_gender = view.findViewById(R.id.cmb_n5_gender);
        cmbN5_relation = view.findViewById(R.id.cmb_n5_relationship);
        cmbN5_occupation = view.findViewById(R.id.cmb_n5_occupation);
        btnN5_canWrite_yes = view.findViewById(R.id.btn_n5_write_yes);
        btnN5_canWrite_no = view.findViewById(R.id.btn_n5_write_no);
        layoutN5_otherOccu = view.findViewById(R.id.layout_n5_other_occupation);
        n5BtnClose = view.findViewById(R.id.btn_n5_close);


        cmbDataInit();


        setActionListener();
        // Inflate the layout for this fragment
        return view;
    }


    private void setActionListener() {

        radioBtnAppointNominee_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioBtnAppointNominee_yes.setChecked(false);
                layoutWhyNot.setVisibility(View.VISIBLE);
                initComboBox(cmbWhyNot, listReasonWhyNot);

                layoutNominee1.setVisibility(View.GONE);
                layoutNominee2.setVisibility(View.GONE);
                layoutNominee3.setVisibility(View.GONE);
                layoutNominee4.setVisibility(View.GONE);
                layoutNominee5.setVisibility(View.GONE);
                btnAddMoreNominee.setVisibility(View.GONE);

                numOfNominee = 0;
                hasNominee = false;

            }
        });

        radioBtnAppointNominee_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioBtnAppointNominee_no.setChecked(false);
                layoutWhyNot.setVisibility(View.GONE);
                layoutSpecificReason.setVisibility(View.GONE);
                layoutNominee1.setVisibility(View.VISIBLE);
                btnAddMoreNominee.setVisibility(View.VISIBLE);
                initComboBox(cmbN1_relationship, listNomineeRelationship);
                initComboBox(cmbN1_gender, listNomineeGender);
                initComboBox(cmbN1_occupation, listNomineeOccupation);
                numOfNominee = 1;
                hasNominee = true;
            }
        });

        cmbWhyNot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 6) {
                    layoutSpecificReason.setVisibility(View.VISIBLE);
                } else {
                    layoutSpecificReason.setVisibility(View.GONE);
                }
            }
        });


        btnAddMoreNominee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNomineeActionHandler();
            }
        });


        firstNomineeActionsHandler();
        secondNomineeActionsHandler();
        thirdNomineeActionsHandler();
        fourthNomineeActionsHandler();
        fifthNomineeActionsHandler();



    }

    private void firstNomineeActionsHandler() {

        cmbN1_occupation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10)    layoutN1_otherOccu.setVisibility(View.VISIBLE);
                else    layoutN1_otherOccu.setVisibility(View.GONE);
            }
        });
        btnN1_canWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   btnN1_canWrite_no.setChecked(false);     }
        });
        btnN1_canWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    btnN1_canWrite_yes.setChecked(false);    }
        });
    }

    private void secondNomineeActionsHandler() {

        cmbN2_occupation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10)    layoutN2_otherOccu.setVisibility(View.VISIBLE);
                else    layoutN2_otherOccu.setVisibility(View.GONE);
            }
        });
        btnN2_canWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   btnN2_canWrite_no.setChecked(false);     }
        });
        btnN2_canWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    btnN2_canWrite_yes.setChecked(false);    }
        });
    }

    private void thirdNomineeActionsHandler() {

        cmbN3_occupation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10)    layoutN3_otherOccu.setVisibility(View.VISIBLE);
                else    layoutN3_otherOccu.setVisibility(View.GONE);
            }
        });
        btnN3_canWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   btnN3_canWrite_no.setChecked(false);     }
        });
        btnN3_canWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    btnN3_canWrite_yes.setChecked(false);    }
        });

        n3BtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutNominee3.setVisibility(View.GONE);
                n3BtnClose.setVisibility(View.VISIBLE);
                numOfNominee--;
            }
        });
    }
    private void fourthNomineeActionsHandler() {

        cmbN4_occupation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10)    layoutN4_otherOccu.setVisibility(View.VISIBLE);
                else    layoutN4_otherOccu.setVisibility(View.GONE);
            }
        });
        btnN4_canWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   btnN4_canWrite_no.setChecked(false);     }
        });
        btnN4_canWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    btnN4_canWrite_yes.setChecked(false);    }
        });

        n4BtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutNominee4.setVisibility(View.GONE);
                n3BtnClose.setVisibility(View.VISIBLE);
                numOfNominee--;
            }
        });
    }

    private void fifthNomineeActionsHandler() {

        cmbN5_occupation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 10)    layoutN5_otherOccu.setVisibility(View.VISIBLE);
                else    layoutN5_otherOccu.setVisibility(View.GONE);
            }
        });
        btnN5_canWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   btnN5_canWrite_no.setChecked(false);     }
        });
        btnN5_canWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    btnN5_canWrite_yes.setChecked(false);    }
        });

        n5BtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutNominee5.setVisibility(View.GONE);
                n4BtnClose.setVisibility(View.VISIBLE);
                numOfNominee--;
            }
        });
    }

    private void addNomineeActionHandler() {

        if (numOfNominee == 1) {
            if (tvN1_fName.getText().length() < 3) {
                Toast.makeText(context, "Nominee 1 name invalid", Toast.LENGTH_SHORT).show();
                tvN1_fName.requestFocus();
            } else if (tvN1_lName.getText().length() < 3) {
                Toast.makeText(context, "Nominee 1 name invalid", Toast.LENGTH_SHORT).show();
                tvN1_lName.requestFocus();
            } else {
                layoutNominee2.setVisibility(View.VISIBLE);
                numOfNominee = 2;

                initComboBox(cmbN2_gender, listNomineeGender);
                initComboBox(cmbN2_relationship, listNomineeRelationship);
                initComboBox(cmbN2_occupation, listNomineeOccupation);
            }

        } else if (numOfNominee == 2) {
            if (tvN2_fName.getText().length() < 3) {
                Toast.makeText(context, "Nominee 2 name invalid", Toast.LENGTH_SHORT).show();
                tvN2_fName.requestFocus();
            } else if (tvN2_lName.getText().length() < 3) {
                Toast.makeText(context, "Nominee 2 name invalid", Toast.LENGTH_SHORT).show();
                tvN2_lName.requestFocus();
            } else {
                layoutNominee3.setVisibility(View.VISIBLE);
                numOfNominee = 3;

                initComboBox(cmbN3_gender, listNomineeGender);
                initComboBox(cmbN3_relation, listNomineeRelationship);
                initComboBox(cmbN3_occupation, listNomineeOccupation);
            }
        } else if (numOfNominee == 3) {
            if(tvN3_name.getText().length() <3){
                Toast.makeText(context, "Nominee 3 name invalid", Toast.LENGTH_SHORT).show();
                tvN3_name.requestFocus();
            } else {
                layoutNominee4.setVisibility(View.VISIBLE);
                n3BtnClose.setVisibility(View.GONE);
                numOfNominee = 4;

                initComboBox(cmbN4_gender, listNomineeGender);
                initComboBox(cmbN4_relation, listNomineeRelationship);
                initComboBox(cmbN4_occupation, listNomineeOccupation);
            }

        } else if (numOfNominee == 4) {
            if(tvN4_name.getText().length() <3){
                Toast.makeText(context, "Nominee 3 name invalid", Toast.LENGTH_SHORT).show();
                tvN4_name.requestFocus();
            } else {
                layoutNominee5.setVisibility(View.VISIBLE);
                n4BtnClose.setVisibility(View.GONE);
                numOfNominee = 5;

                initComboBox(cmbN5_gender, listNomineeGender);
                initComboBox(cmbN5_relation, listNomineeRelationship);
                initComboBox(cmbN5_occupation, listNomineeOccupation);
            }
        } else if (numOfNominee == 5 ) {
            Toast.makeText(context, "You can't add more than 5", Toast.LENGTH_SHORT).show();
            
        }


    }


    private void initComboBox(AutoCompleteTextView popupEmailComboBox, ArrayList<String> contentList) {


        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(context, R.layout.combo_item, contentList);
        popupEmailComboBox.setAdapter(adapterItems);
    }

    private void cmbDataInit() {

        listReasonWhyNot = new ArrayList<>(Arrays.asList("Select Reason Why Not?",
                "All eligible household members have other commitments that occupy their time.",
                "I am uncertain about the ability of the household members to comply with the program's expectations or conditions.",
                "The health or physical condition of the eligible household members prevents me from participating.",
                "I am not convinced that the program will provide meaningful benefits.							",
                "The program activities don't align with my interests.",
                "Other (specify)"));

        listNomineeRelationship = new ArrayList<>(Arrays.asList("Select Relationship with Respondent",
                "Household Head",
                "Spouse/Wife",
                "Son/Daughter",
                "Son/Daughter in law",
                "Grandchild",
                "Father/Mother",
                "Father/Mother in law",
                "Sibling",
                "Sibling in law",
                "Other Relative",
                "Domestic Worker",
                "No Relation",
                "Does not know"));

        listNomineeGender = new ArrayList<>(Arrays.asList("Select Respondent Gender",
                "Male",
                "Female"));

        listNomineeOccupation = new ArrayList<>(Arrays.asList("Select Nominee Occupation",
                "Employed in a formal job ",
                "Casual work or daily wage labor ",
                "Self-employed in a business or trade ",
                "Agricultural work or farming ",
                "Homemaker (manages household activities) ",
                "Unemployed and actively seeking work ",
                "Student or in education ",
                "Disabled or chronically ill ",
                "Retired or not working ",
                "Other (specify) "));
    }

    public static int getNumOfNominee() {
        return numOfNominee;
    }
    public static boolean getHasNominee(){
        return hasNominee;
    }



}