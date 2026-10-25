package ctn.stonecraft.api.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class PlayerTool {
	/**
	 * 向所有玩家发送消息
	 */
	public static void sendChatMessageToAllPlayers(List<ServerPlayer> level, Component component) {
		for (ServerPlayer player : level) {
			player.sendSystemMessage(component);
		}
	}
	
	/**
	 * 向特定玩家发送消息
	 */
	public static void sendChatMessageToPlayer(ServerPlayer player, Component component) {
		player.sendSystemMessage(component);
	}
	
	/**
	 * 向所有玩家发送消息，自己和其他玩家可以收到不同的消息
	 *
	 * @param self          接收自己消息的玩家对象
	 * @param selfMessage   发送给指定self玩家的消息内容
	 * @param players       玩家列表，将向这些玩家发送othersMessage消息
	 * @param othersMessage 发送给players列表中所有玩家的消息内容
	 */
	public static void sendChatMessageAllPlayers(Player self, Component selfMessage, List<ServerPlayer> players, Component othersMessage) {
		self.sendSystemMessage(selfMessage);
		sendChatMessageToAllPlayers(players, othersMessage);
	}
}
