package com.moez.QKSMS.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment

class MessageDetailsDialogFragment : DialogFragment() {

    private var details: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        details = arguments?.getString(ARG_DETAILS) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MessageDetailsDialog(details = details) {
                    dismiss()
                }
            }
        }
    }

    companion object {
        private const val ARG_DETAILS = "details"

        fun newInstance(details: String): MessageDetailsDialogFragment {
            val fragment = MessageDetailsDialogFragment()
            val args = Bundle()
            args.putString(ARG_DETAILS, details)
            fragment.arguments = args
            return fragment
        }
    }
}
