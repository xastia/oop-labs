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

class Work12 : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
           parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_RESPONSE2 to which))
         }
        return AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.title2))
            .setPositiveButton(resources.getString(R.string.yes), listener)
            .setNeutralButton(resources.getString(R.string.cancel), listener)
            .setNegativeButton(resources.getString(R.string.previous), listener)
            .create()
    }




    companion object {
        private val TAG2 = "work12"
        private val REQUEST_KEY = "$TAG2:defaultRequestKey"
        private val KEY_RESPONSE2 = "RESPONSE"

        fun show(manager: FragmentManager) {
            val dialogFragment = Work12()
            dialogFragment.show(manager,TAG2)
        }

        fun setupListener(manager: FragmentManager, lifecycleOwner: LifecycleOwner) {
            manager.setFragmentResultListener(REQUEST_KEY, lifecycleOwner, FragmentResultListener { _, result ->
                    val which = result.getInt(KEY_RESPONSE2)
                    when (which) {
                        DialogInterface.BUTTON_NEGATIVE -> Work11.show(manager)
                    }

                })
        }


    }

}
