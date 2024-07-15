package com.example.lab11

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner

class Work11 : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_RESPONSE to which))
        }
        return AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.title1))
            .setPositiveButton(resources.getString(R.string.next), listener)
            .setNeutralButton(resources.getString(R.string.cancel), listener)
            .create()
    }




    companion object {
        private val TAG = "work11"
        private val REQUEST_KEY = "$TAG:defaultRequestKey"
        private val KEY_RESPONSE = "RESPONSE"

        fun show(manager: FragmentManager) {
            val dialogFragment = Work11()
            dialogFragment.show(manager, TAG)
        }

        fun setupListener(manager: FragmentManager, lifecycleOwner: LifecycleOwner) {
            manager.setFragmentResultListener(REQUEST_KEY, lifecycleOwner, FragmentResultListener { _, result ->
                    val which = result.getInt(KEY_RESPONSE)
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> Work12.show(manager)
                    }

                })
        }

    }}



