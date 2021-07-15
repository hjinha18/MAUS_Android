package com.example.maus.ui.main.timer

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.example.maus.R
import java.time.Year

class TimerSettingDateDialog(context: Context) {
    private val dialog = Dialog(context)
    val context = context
    lateinit var datePicker: DatePicker

    fun create(dateDayTextView: TextView){
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_date_setting)

        //크기
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        val cancelBtn = dialog.findViewById<Button>(R.id.cancelDateBtn)
        cancelBtn.setOnClickListener{
            dialog.dismiss()
        }

        datePicker = dialog.findViewById<DatePicker>(R.id.datePicker)

        val saveDateBtn = dialog.findViewById<Button>(R.id.saveDateBtn)
        saveDateBtn.setOnClickListener{
            Toast.makeText(context,"${datePicker.month + 1} : ${datePicker.dayOfMonth}", Toast.LENGTH_SHORT).show()
            dateDayTextView.text = "${datePicker.year}.${datePicker.month + 1}.${datePicker.dayOfMonth}"

            dialog.dismiss()
        }

        //확인버튼 누르면 date 값을 넘겨야 함

        dialog.show()
    }

//    interface DialogListener{
//        fun onSaveClick(year:Int, month:Int, day:Int)
//        fun onCancelClick()
//    }
}