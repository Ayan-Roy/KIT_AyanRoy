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
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentPersonalInfo extends Fragment {


    LinearLayout layoutSpouseInfo;

    TextInputLayout layoutSpecificIncome;
    TextInputEditText tvResFName, tvResMName, tvResLName, tvResAge, tvResId, tvResPhone,
            tvSpouseFName, tvSpouseMName, tvSpouseLName, tvSpecificIncomeSrc, tvAvgIncome, tvGpsLat, tvGpsLong;
    AutoCompleteTextView cmbResRelationToHead, cmbResGender, cmbResMaritalSts, cmbResLegalSts, cmbMainIncomeSource,
            cmbCurrency, cmbReason, cmbState, cmbCountry, cmbPayam, cmbBoma;

    RadioButton supportType_public, supportType_direct;
    Context context;

    ArrayList<String> listResRelationship;
    ArrayList<String> listResGender;
    ArrayList<String> listResMaritalSts;
    ArrayList<String> listLegalSts;
    ArrayList<String> listIncomeSrc;
    ArrayList<String> listCurrency;
    ArrayList<String> listReason_public;
    ArrayList<String> listReason_direct;
    ArrayList<String> listState;
    ArrayList<String> listCountry;
    ArrayList<String> listPayam;
    ArrayList<String> listBoma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        context = getContext();

        /**     Hooks for Personal Info     */
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


        /**     Hooks for Household Info     */
        tvSpecificIncomeSrc = view.findViewById(R.id.tv_sCriteria_specific_income_src);
        tvAvgIncome = view.findViewById(R.id.tv_sCriteria_avg_income);
        tvGpsLat = view.findViewById(R.id.tv_sCriteria_gps_lat);
        tvGpsLong = view.findViewById(R.id.tv_sCriteria_gps_long);

        cmbMainIncomeSource = view.findViewById(R.id.tv_sCriteria_cmb_src_of_income);
        cmbCurrency = view.findViewById(R.id.tv_sCriteria_cmb_currency);
        cmbReason = view.findViewById(R.id.tv_sCriteria_cmb_reason);
        cmbState = view.findViewById(R.id.tv_sCriteria_state_name);
        cmbCountry = view.findViewById(R.id.tv_sCriteria_country_name);
        cmbPayam = view.findViewById(R.id.tv_sCriteria_payam_name);
        cmbBoma = view.findViewById(R.id.tv_sCriteria_boma_name);

        supportType_public = view.findViewById(R.id.rBtn_sType_public);
        supportType_direct = view.findViewById(R.id.rBtn_sType_direct);

        layoutSpecificIncome = view.findViewById(R.id.txtLayout_specificIncome);

        cmdDataInit();


        initComboBox(cmbResRelationToHead, listResRelationship);
        initComboBox(cmbResGender, listResGender);
        initComboBox(cmbResMaritalSts, listResMaritalSts);
        initComboBox(cmbResLegalSts, listLegalSts);
        initComboBox(cmbMainIncomeSource, listIncomeSrc);
        initComboBox(cmbCurrency, listCurrency);
        initComboBox(cmbState, listState);


        setActionListener();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void setActionListener() {

        Log.e(TAG, "setActionListener: ");
        cmbResMaritalSts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    layoutSpouseInfo.setVisibility(View.VISIBLE);
                } else {
                    if (layoutSpouseInfo.getVisibility() == View.VISIBLE)
                        layoutSpouseInfo.setVisibility(View.GONE);
                }
            }
        });

        cmbMainIncomeSource.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 11) {
                    layoutSpecificIncome.setVisibility(View.VISIBLE);
                } else {
                    if (layoutSpecificIncome.getVisibility() == View.VISIBLE)
                        layoutSpecificIncome.setVisibility(View.GONE);
                }
            }
        });

        supportType_public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportType_direct.setSelected(false);
                initComboBox(cmbReason, listReason_public);
            }
        });

        supportType_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                supportType_public.setSelected(false);
                initComboBox(cmbReason, listReason_direct);
            }
        });

        cmbState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    initComboBox(cmbCountry, listCountry);
                }
            }
        });

        cmbCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    initComboBox(cmbPayam, listPayam);
                }
            }
        });

        cmbPayam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    initComboBox(cmbBoma, listBoma);
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

        listIncomeSrc = new ArrayList<>(Arrays.asList("Select Household Main Source of Income",
                "None",
                "Selling of farm produce including crops and livestock, fishing",
                "Selling of non-farm goods (e.g. tea, fire wood, charcoal, grass, alcohol)",
                "Casual labour",
                "Formal employment",
                "Remittances",
                "Gift from family/ friends",
                "Assistance from the Government",
                "Assistance from NGOs/charitable organization/church/mosque",
                "Pension",
                "Other (specify)"));

        listCurrency = new ArrayList<>(Arrays.asList("Currency",
                "Sudanese Pound",
                "USD",
                "Pound",
                "Euro"));
        listReason_public = new ArrayList<>(Arrays.asList("Select Selection Reason",
                "Poor household with no sufficient income to sustain the household",
                "Household contain able bodied youth member (18-35)",
                "Household headed by young men and women between the ages of 18 and 35",
                "Many members who are dependents (HH with dependants greater than 3)",
                "Poor household which have persons with severe disabilities"));

        listReason_direct = new ArrayList<>(Arrays.asList("Select Selection Reason",
                "Child headed households with no alternate income support",
                "Elderly headed household lacking alternate income support and able bodied member",
                "Persons with disability headed household lacking alternate income support and able bodied member",
                "Chronically ill headed household lacking alternate income and able bodied member",
                "Female headed household lacking alternate income support and able-bodied member"));
        listState = new ArrayList<>(Arrays.asList("Select State",
                "UPPER NILE",
                "JONGLEI",
                "UNITY WARRAP",
                "NORTHERN BAHR EL GHAZAL",
                "WESTERN BAHR EL GHAZAL",
                "LAKES",
                "WESTERN EQUATORIA",
                "CENTRAL EQUATORIA",
                "EASTERN EQUATORIA"));

        listCountry = new ArrayList<>(Arrays.asList("Courtya Select County",
                "Select County FANGAK",
                "KHORFLUS",
                "AYOD",
                "DUK",
                "UROR",
                "NYROL",
                "АКОВО",
                "POCHALLA PBOR",
                "TWIC EAST",
                "BOR SOUTH",
                "RENK",
                "MANVO",
                "FASHODA",
                "MELUTH",
                "MABAN",
                "MAWUT",
                "LUAKPINY",
                "LONGOCHUK"));

        listPayam = new ArrayList<>(Arrays.asList("Select Payam",
                "Select Payam CHAMMEDI",
                "GERGER",
                "JALHAK",
                "NORTH RENK",
                "SOUTH RENK"));

        listPayam = new ArrayList<>(Arrays.asList("Select Boma",
                "BABANIS",
                "HBOUBDIT",
                "CHAMMEDI",
                "LABIOR",
                "Norm"));


    }


    private void initComboBox(AutoCompleteTextView popupEmailComboBox, ArrayList<String> contentList) {


        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(context, R.layout.combo_item, contentList);
        popupEmailComboBox.setAdapter(adapterItems);
    }
}