package com.wt.mggui.view

import tornadofx.*

/**
 * 主界面
 * Created by wt on 2017/1/23.
 */
class MainView : View("MG-gui by wt") {

    private val generatorView: GeneratorView by inject()
    override val root = generatorView.root

}