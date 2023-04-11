package de.simonsator.partyandfriends.velocity.extensions.atparty.configuration;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.extensions.atparty.APMain;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

/**
 * @author JT122406
 * @version 1.0.2 11.04.23
 * Loader for the AtParty extension for Velocity
 */
@Plugin(id = "atparty", name = "AtParty", version = "1.0.2-RELEASE",
		url = "https://www.spigotmc.org/resources/party-for-party-and-friends-for-bungeecord.37625/",
		description = "This is a rather simple extension for Party and Friends (as well for the extended as well as for the not extended version). If you have installed this extension, you just need to write @ Party (without space) into the chat to write into the party chat."
		, authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends")})
public class APLoader {


	private final Path folder;

	@Inject
	public APLoader(Path folder) {
		this.folder = folder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new APMain(folder),
				"atparty", "AtParty", "1.0.2-RELEASE", "JT122406, Simonsator"));
	}
}
