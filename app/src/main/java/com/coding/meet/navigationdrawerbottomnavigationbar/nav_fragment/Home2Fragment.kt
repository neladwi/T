package com.coding.meet.navigationdrawerbottomnavigationbar.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.coding.meet.navigationdrawerbottomnavigationbar.R
import com.coding.meet.navigationdrawerbottomnavigationbar.bottom_fragment.CartFragment
import com.coding.meet.navigationdrawerbottomnavigationbar.bottom_fragment.ProfileFragment
import com.coding.meet.navigationdrawerbottomnavigationbar.bottom_fragment.BookFragment
import com.coding.meet.navigationdrawerbottomnavigationbar.bottom_fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Home2Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    activity?.title = "Home"
                }
                R.id.bottom_book -> {
                    replaceFragment(BookFragment())
                    activity?.title = "Book"
                }
                R.id.bottom_cart -> {
                    replaceFragment(CartFragment())
                    activity?.title = "Cart"
                }
                R.id.bottom_profile -> {
                    replaceFragment(ProfileFragment())
                    activity?.title = "Profile"
                }
            }
            true
        }

        replaceFragment(ProfileFragment())
        activity?.title = "Category"
        bottomNavigationView.selectedItemId = R.id.bottom_home

        val addFab = view.findViewById<FloatingActionButton>(R.id.addFabBtn)
        addFab.setOnClickListener {
            Toast.makeText(context,"Add Clicked",Toast.LENGTH_LONG).show()
        }
        return view
    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment,fragment)
            .commit()
    }

}