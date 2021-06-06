package com.bersyte.noteapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bersyte.noteapp.R
import com.bersyte.noteapp.databinding.FragmentUpdateNoteBinding
import com.bersyte.noteapp.model.Note
import com.bersyte.noteapp.toast
import com.bersyte.noteapp.viewmodel.NoteViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class UpdateNoteFragment : BaseFragment<NoteViewModel, FragmentUpdateNoteBinding>() {

    private val args: UpdateNoteFragmentArgs by navArgs()
    private lateinit var currentNote: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUpdateNoteBinding.inflate(
            inflater,
            container,
            false
        )
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)
        currentNote = args.note!!

        binding!!.etNoteBodyUpdate.setText(currentNote.noteBody)
        binding!!.etNoteTitleUpdate.setText(currentNote.noteTitle)

        binding!!.fabDone.setOnClickListener {
            val title = binding!!.etNoteTitleUpdate.text.toString().trim()
            val body = binding!!.etNoteBodyUpdate.text.toString().trim()

            if (title.isNotEmpty()) {
                val note = Note(currentNote.id, title, body)
                viewModel.updateNote(note)

                view.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)

            } else {
                activity?.toast("Enter a note title please")
            }
        }
    }

    private fun deleteNote() {
        AlertDialog.Builder(activity).apply {
            setTitle("Delete Note")
            setMessage("Are you sure you want to permanently delete this note?")
            setPositiveButton("DELETE") { _, _ ->
                viewModel.deleteNote(currentNote)
                view?.findNavController()?.navigate(
                    R.id.action_updateNoteFragment_to_homeFragment
                )
            }
            setNegativeButton("CANCEL", null)
        }.create().show()

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_update_note, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_delete -> {
                deleteNote()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
