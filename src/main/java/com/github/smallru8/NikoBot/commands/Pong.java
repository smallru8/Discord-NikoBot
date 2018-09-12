package com.github.smallru8.NikoBot.commands;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import com.github.smallru8.NikoBot.embedsender.Pink;

import net.dv8tion.jda.core.entities.Message;

public class Pong {

	public static void pong (Message msg) {
		long ms = msg.getCreationTime().until(LocalDateTime.now().atOffset(ZoneOffset.of("+8")), ChronoUnit.MILLIS);
		Pink.output(msg.getChannel(),"Pong!:ping_pong:"+ms+"ms","");
	}
	
}
