package com.example.pictgram.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionsController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/login") // /login の呼び出しで index メソッドはログイン画面を表示
	public String index() {
		return "sessions/new";
	}

	@GetMapping("/login-failure") // /login-failure の呼び出しで loginFailure メソッドはログイン失敗の Flash メッセージを表示
	public String loginFailure(Model model, Locale locale) {
		model.addAttribute("hasMessage", true);
		model.addAttribute("class", "alert-danger");
		model.addAttribute("message", messageSource.getMessage("sessions.loginFailure.flash", new String[] {}, locale));

		return "sessions/new";
	}

	@GetMapping("/logout-complete") // /logout-complete の呼び出しで logout メソッドはログアウト完了の Flash メッセージを表示
	public String logoutComplete(Model model, Locale locale) {
		model.addAttribute("hasMessage", true);
		model.addAttribute("class", "alert-info");
		model.addAttribute("message",
				messageSource.getMessage("sessions.logoutComplete.flash", new String[] {}, locale));

		return "layouts/complete";
	}
}