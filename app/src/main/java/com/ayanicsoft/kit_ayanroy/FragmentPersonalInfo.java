package com.ayanicsoft.kit_ayanroy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentPersonalInfo extends Fragment {


    LinearLayout layoutSpouseInfo;
    TextInputEditText tvResFName, tvResMName, tvResLName, tvResAge, tvResId, tvResPhone,
            tvSpouseFName, tvSpouseMName, tvSpouseLName;
    AutoCompleteTextView cmbResRelationToHead, cmbResGender, cmbResMaritalSts, cmbResLegalSts;
    Context context;

    ArrayList<String> listResRelationship;
    ArrayList<String> listResGender;
    ArrayList<String> listResMaritalSts;
    ArrayList<String> listLegalSts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        context = getContext();
        tvResFName = view.findViewById(R.id.tv_pInfo_fName);
        tvResMName = view.findViewById(R.id.tv_pInfo_mName);
        tvResLName = view.findViewById(R.id.tv_pInfo_lName);
        tvResAge = view.findViewById(R.id.tv_pInfo_age);
        tvResId = view.findViewById(R.id.tv_pInfo_res_id);
        tvResPhone = view.findViewById(R.id.tv_pInfo_res_phone);

        tvSpouseFName = view.findViewById(R.id.tv_pInfo_res_sp_fName);
        tvSpouseMName = view.findViewById(R.id.tv_pInfo_res_sp_mName);
        tvSpouseLName = view.findViewById(R.id.tv_pInfo_res_sp_lName);

        cmbResRelationToHead = view.findViewById(R.id.tv_pInfo_res_relation);
        cmbResGender = view.findViewById(R.id.tv_pInfo_res_gender);
        cmbResMaritalSts = view.findViewById(R.id.tv_pInfo_res_m_status);
        cmbResLegalSts = view.findViewById(R.id.tv_pInfo_l_status);

        layoutSpouseInfo = view.findViewById(R.id.layout_marital_sts_married);

        cmdDataInit();


        initComboBox(cmbResRelationToHead, listResRelationship);
        initComboBox(cmbResGender, listResGender);
        initComboBox(cmbResMaritalSts, listResMaritalSts);
        initComboBox(cmbResLegalSts, listLegalSts);


        setActionListener();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    private void setActionListener() {

        Log.e(TAG, "setActionListener: " );
        cmbResMaritalSts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemSelected: " );
                if(position == 2){
                    layoutSpouseInfo.setVisibility(View.VISIBLE);
                }else{
                    if(layoutSpouseInfo.getVisibility() == View.VISIBLE)
                        layoutSpouseInfo.setVisibility(View.GONE);
                }
            }
        });


    }

    private void cmdDataInit() {

        listResRelationship = new ArrayList<>(Arrays.asList("Select Relationship with Respondent",
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

        listResGender = new ArrayList<>(Arrays.asList("Select Respondent Gender",
                "Male",
                "Female"));

        listResMaritalSts = new ArrayList<>(Arrays.asList("Select Respondent Marital Status",
                "Single",
                "Married",
                "Widow/Widower",
                "Separated",
                "Divorce"));

        listLegalSts = new ArrayList<>(Arrays.asList("Select Respondent Legal Status",
                "Host",
                "Returnee",
                "Refugee",
                "IDP",
                "Migrant Worker"));



    }


    private void initComboBox(AutoCompleteTextView popupEmailComboBox, ArrayList<String> contentList) {


        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(context, R.layout.combo_item, contentList);
        popupEmailComboBox.setAdapter(adapterItems);
    }
}