package com.example.fit_i

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MypageFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mypage, container, false)

        val vv = inflater.inflate(R.layout.fragment_mypage, container, false)
        val ibsetting = vv.findViewById<View>(R.id.ib_setting) as ImageButton
        val ivnextlike = vv.findViewById<View>(R.id.iv_next_like) as ImageView
        val ivnextnotice = vv.findViewById<View>(R.id.iv_next_notice) as ImageView
        val ivnextpermisson = vv.findViewById<View>(R.id.iv_next_permisson) as ImageView
        val tvgotoprofile = vv.findViewById<View>(R.id.tv_go_modifyProfile) as TextView
        val ivnextreview = vv.findViewById<View>(R.id.iv_next_review) as ImageView
        val swtmy = vv.findViewById<View>(R.id.swt_my) as Switch




        //설정
        ibsetting.setOnClickListener {
            val mypageSettingFragment = MypageSettingFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageSettingFragment)
            transaction.commit()
        }

        //찜 목록
        ivnextlike.setOnClickListener {
            val mypageLikelistFragment = MypageLikelistFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()


            transaction.replace(R.id.fl_container, mypageLikelistFragment)
            transaction.commit()
        }
        // 공지사항
        ivnextnotice.setOnClickListener {
            val mypageNoticeFragment = MypageNoticeFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageNoticeFragment)
            transaction.commit()
        }
        //프로필 수정
        tvgotoprofile.setOnClickListener {
            val mypageModifyProfileFragment = MypageModifyProfileFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageModifyProfileFragment)
            transaction.commit()
        }
        //이용약관
        ivnextpermisson.setOnClickListener {
            val mypagepermissonFragment = MypagepermissonFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypagepermissonFragment)
            transaction.commit()
        }
        //매칭 후기 작성하기
        ivnextreview.setOnClickListener {
            val mypageReviewBinding = MypageReviewFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageReviewBinding)
            transaction.commit()
        }
        //스위치 눌렀을때 기능 추가하기
        swtmy.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    //체크된 상태 취소시 반응 추가

                }
                else{
                    //체크된 상태 만들 시 코드

                }
            }
        })




        return vv


    }
}