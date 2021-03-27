package localhost.adifferentperson.frogesp;

import dev.rootnet.addons.api.addon.Addon;
import dev.rootnet.addons.api.annotations.RootnetAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@SuppressWarnings("unused")
@RootnetAddon(name = "ImpostorESP", author = "ADifferentPerson", version = "1.1.1")
public final class ImpostorEspAddon extends Addon {
    private static final String SUS_URL = "https://soulbond.on-top.wtf/Ao9I20SF_";
    private static final Minecraft MC = Minecraft.getMinecraft();
    static ResourceLocation sus;
    static double susRatio;
    static ImpostorEspAddon INSTANCE;

    @Override
    public final void init() {
        INSTANCE = this;
        log(Level.INFO, "Initializing ImpostorESP Addon...");
        try {
            final BufferedImage image = ImageIO.read(new URL(SUS_URL));
            susRatio = ((double) image.getWidth()) / ((double) image.getHeight());
            final DynamicTexture dynamicTexture = new DynamicTexture(image);
            dynamicTexture.loadTexture(MC.getResourceManager());
            sus = MC.getTextureManager().getDynamicTextureLocation("SUS", dynamicTexture);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        getRootnet().registerModule(this, new ImpostorEspModule());
    }
}
