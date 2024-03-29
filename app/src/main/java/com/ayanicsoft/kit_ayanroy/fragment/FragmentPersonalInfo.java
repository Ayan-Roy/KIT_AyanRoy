package com.ayanicsoft.kit_ayanroy.fragment;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ayanicsoft.kit_ayanroy.R;
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

    static int[] editTextIds = {
            R.id.editText0, R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4, R.id.editText5,
            R.id.editText6, R.id.editText7, R.id.editText8, R.id.editText9, R.id.editText10, R.id.editText11,
            R.id.editText12, R.id.editText13, R.id.editText14, R.id.editText15, R.id.editText16, R.id.editText17,
            R.id.editText18, R.id.editText19, R.id.editText20, R.id.editText21, R.id.editText22, R.id.editText23,
            R.id.editText24, R.id.editText25, R.id.editText26, R.id.editText27, R.id.editText28, R.id.editText29,
            R.id.editText30, R.id.editText31, R.id.editText32, R.id.editText33, R.id.editText34, R.id.editText35
    };

    TextView tvTotalMember;

    RadioButton supportType_public, supportType_direct, canReadWrite_yes, canReadWrite_no;
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
    ArrayList<TextInputEditText> listHouseSize;
    static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_personal_info, container, false);

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


        /**     Hooks for Selection Info     */
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
        canReadWrite_yes = view.findViewById(R.id.rbtn_read_write_yes);
        canReadWrite_no = view.findViewById(R.id.rbtn_read_write_no);

        tvTotalMember = view.findViewById(R.id.tv_ttl_member);

        layoutSpecificIncome = view.findViewById(R.id.txtLayout_specificIncome);


        /**     Hooks for Selection Info     */
        // Add EditText fields to the list
        listHouseSize = new ArrayList<>();
        for (int i = 1; i <= 36; i++) {
            int editTextId = getResources().getIdentifier("editText" + i, "id", context.getPackageName());
            TextInputEditText editText = view.findViewById(editTextId);
            listHouseSize.add(editText);
        }


        cmdDataInit();


        initComboBox(cmbResRelationToHead, listResRelationship);
        initComboBox(cmbResGender, listResGender);
        initComboBox(cmbResMaritalSts, listResMaritalSts);
        initComboBox(cmbResLegalSts, listLegalSts);
        initComboBox(cmbMainIncomeSource, listIncomeSrc);
        initComboBox(cmbCurrency, listCurrency);
        initComboBox(cmbState, listState);


        setActionListener();
        // clearAllData();
        return view;
    }

    private void houseHoleTableCellListener(TextInputEditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Update sum when text changes
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        int totalSum = 1;
        for (TextInputEditText editText : listHouseSize) {
            String valueStr = editText.getText().toString();
            if (!valueStr.isEmpty()) {
                int value = Integer.parseInt(valueStr);
                totalSum += value;
            }
        }
        // Update TextView with the sum
        tvTotalMember.setText("" + totalSum);
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
                supportType_direct.setChecked(false);
                initComboBox(cmbReason, listReason_public);
            }
        });

        supportType_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                supportType_public.setChecked(false);
                initComboBox(cmbReason, listReason_direct);
            }
        });

        cmbState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    initComboBox(cmbCountry, listCountry);
                }
            }
        });

        cmbCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    initComboBox(cmbPayam, listPayam);
                }
            }
        });

        cmbPayam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    initComboBox(cmbBoma, listBoma);
                }
            }
        });

        canReadWrite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canReadWrite_no.setChecked(false);
            }
        });
        canReadWrite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canReadWrite_yes.setChecked(false);
            }
        });



        setupEditTextListeners();
    }


    private void setupEditTextListeners() {

        for (int editTextId : editTextIds) {
            TextInputEditText editText = view.findViewById(editTextId);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    calculateTotal();
                }
            });
        }
    }

    private void calculateTotal() {
        int total = 1; //including me

        for (int editTextId : editTextIds) {
            TextInputEditText editText = view.findViewById(editTextId);
            int value = parseEditTextValue(editText.getText().toString());
            total += value;
        }
        tvTotalMember.setText(total + "");
    }

    private int parseEditTextValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
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

        listBoma = new ArrayList<>(Arrays.asList("Select Boma",
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

    public static void clearAllData() {

        int[] textViewIds = {
                R.id.tv_pInfo_fName, R.id.tv_pInfo_mName, R.id.tv_pInfo_lName,
                R.id.tv_pInfo_age, R.id.tv_pInfo_res_id, R.id.tv_pInfo_res_phone,
                R.id.tv_pInfo_res_sp_fName, R.id.tv_pInfo_res_sp_mName,
                R.id.tv_pInfo_res_sp_lName, R.id.tv_sCriteria_specific_income_src,
                R.id.tv_sCriteria_avg_income, R.id.tv_sCriteria_gps_lat,
                R.id.tv_sCriteria_gps_long
        };


        for (int textId : textViewIds) {
            TextInputEditText editText = view.findViewById(textId);
            Log.e(TAG, "clearAllData: " + editText);
            editText.setText("");
        }

        for (int editTextId : editTextIds) {
            TextInputEditText editText = view.findViewById(editTextId);
            editText.setText("");
        }
    }

}