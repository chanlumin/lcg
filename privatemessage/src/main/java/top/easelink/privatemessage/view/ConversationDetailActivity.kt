package top.easelink.privatemessage.view

import android.os.Bundle
import android.os.PersistableBundle
import top.easelink.framework.topbase.TopActivity
import top.easelink.privatemessage.R

class ConversationDetailActivity: TopActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_conversation_detail)
    }
}