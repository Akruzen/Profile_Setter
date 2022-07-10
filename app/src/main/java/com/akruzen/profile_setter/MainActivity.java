package com.akruzen.profile_setter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    TextView instructionsTextView, permissionsTextView, description1TextView, description2TextView, actionTextView, label1TextView, label2TextView;
    LinearLayout actionsLinearLayout, divider1, divider2, divider3;
    FloatingActionButton permissionFAB, githubFAB;
    Drawable checkIcon, codeIcon;

    public void goToRepoTapped (View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Akruzen/Profile_Setter"));
        startActivity(browserIntent);
    }

    private void getPermission () {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (!notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    private boolean permissionGranted() {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        return notificationManager.isNotificationPolicyAccessGranted();
    }

    public void checkPermissionTapped (View view) {
        if (!permissionGranted()) {
            Toast.makeText(this, "Please select Pro Set here and allow DnD permission.", Toast.LENGTH_SHORT).show();
            getPermission();
        } else {
            Toast.makeText(this, "Permission already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDynamicColors () {
        // Scroll View background
        scrollView.setBackgroundResource(com.google.android.material.R.color.material_dynamic_primary95);
        // Text views
        instructionsTextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary40));
        permissionsTextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary40));
        description1TextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary10));
        description2TextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary10));
        actionTextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary10));
        label1TextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary10));
        label2TextView.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_primary10));
        // Linear Layouts
        actionsLinearLayout.setBackgroundResource(R.drawable.rounded_corner_shape_dynamic);
        divider1.setBackgroundResource(com.google.android.material.R.color.material_dynamic_tertiary60);
        divider2.setBackgroundResource(com.google.android.material.R.color.material_dynamic_tertiary60);
        divider3.setBackgroundResource(com.google.android.material.R.color.material_dynamic_tertiary60);
        // FABs
        permissionFAB.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_secondary90)));
        githubFAB.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_secondary90)));
        // Icons
        checkIcon.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_secondary40));
        codeIcon.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_secondary40));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        instructionsTextView = findViewById(R.id.textView3);
        permissionsTextView = findViewById(R.id.textView5);
        description1TextView = findViewById(R.id.textView6);
        description2TextView = findViewById(R.id.textView4);
        actionTextView = findViewById(R.id.actionTextView);
        label1TextView = findViewById(R.id.textView9);
        label2TextView = findViewById(R.id.textView10);
        actionsLinearLayout = findViewById(R.id.actionsLinearLayout);
        divider1 = findViewById(R.id.dividerLinearLayout1);
        divider2 = findViewById(R.id.dividerLinearLayout2);
        divider3 = findViewById(R.id.dividerLinearLayout3);
        permissionFAB = findViewById(R.id.checkPermissionFAB);
        githubFAB = findViewById(R.id.githubFAB);
        checkIcon = AppCompatResources.getDrawable(this, R.drawable.ic_round_check_24);
        codeIcon = AppCompatResources.getDrawable(this, R.drawable.ic_round_code_24);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setDynamicColors();
        }
    }
}