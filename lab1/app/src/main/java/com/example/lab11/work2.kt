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

class Work2() : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val groupsList = resources.getStringArray(R.array.arrayOfItems)

        val builder = AlertDialog.Builder(requireContext()).apply {
            setTitle(resources.getString(R.string.title3))
            setSingleChoiceItems(groupsList, 0, null)
            setNeutralButton(resources.getString(R.string.cancel), DialogInterface.OnClickListener { dialog, _ ->
            })
            setPositiveButton(resources.getString(R.string.yes), DialogInterface.OnClickListener { dialog, _ ->
                val index = (dialog as AlertDialog).listView.checkedItemPosition
                val group = groupsList[index]
                parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_GROUP_RESPONSE to group))


            })

        }
        return builder.create()
    }





    companion object {
        val TAG3 = "work2"
        val KEY_GROUP_RESPONSE = "Response"
        val REQUEST_KEY = "TAG3:defaultRequestKey"
        val ARG_GROUP = "ArgGroup"

        fun show(manager: FragmentManager, group: String) {
            val dialogFragment = Work2()
            dialogFragment.arguments = bundleOf(ARG_GROUP to group)
            dialogFragment.show(manager, TAG3)
        }

        fun setupListener(manager: FragmentManager, lifecycleOwner: LifecycleOwner, listener: (String) -> Unit) {
            manager.setFragmentResultListener(REQUEST_KEY, lifecycleOwner, FragmentResultListener {_, result ->
                listener.invoke(result.getString(KEY_GROUP_RESPONSE).toString())
            })
        }



    }

}