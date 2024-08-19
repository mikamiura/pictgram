package com.example.pictgram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionsController {

    @GetMapping("/login")// /login の呼び出しで index メソッドはログイン画面を表示
    public String index() {
        return "sessions/new";
    }

    @GetMapping("/login-failure")// /login-failure の呼び出しで loginFailure メソッドはログイン失敗の Flash メッセージを表示
    public String loginFailure(Model model) {
        model.addAttribute("hasMessage", true);
        model.addAttribute("class", "alert-danger");
        model.addAttribute("message", "Emailまたはパスワードに誤りがあります。");

        return "sessions/new";
    }

    @GetMapping("/logout-complete")// /logout-complete の呼び出しで logout メソッドはログアウト完了の Flash メッセージを表示
    public String logoutComplete(Model model) {
        model.addAttribute("hasMessage", true);
        model.addAttribute("class", "alert-info");
        model.addAttribute("message", "ログアウトしました。");

        return "layouts/complete";
    }
}