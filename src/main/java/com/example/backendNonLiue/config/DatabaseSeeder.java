package com.example.backendNonLiue.config;

import com.example.backendNonLiue.model.Skill;
import com.example.backendNonLiue.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final SkillRepository skillRepository;

    @Override
    public void run(String... args) {
        if (skillRepository.count() == 0) {
            System.out.println("Iniciando a forja do catálogo de habilidades do NON-LIEU...");
            List<Skill> allSkills = new ArrayList<>();

            allSkills.add(buildSkill("Golpe limpo", "Dano leve a um alvo", "FISICO", "fa-hand-fist", "1d6"));
            allSkills.add(buildSkill("Briga de bar", "Dano leve para vários alvos", "FISICO", "fa-users", "1d6"));
            allSkills.add(buildSkill("Agarrar", "Obstrui o movimento do alvo, força sobre força", "FISICO", "fa-handshake-angle", null));
            allSkills.add(buildSkill("Golpe com técnica", "Dano Moderado a um alvo", "FISICO", "fa-user-ninja", "1d8"));
            allSkills.add(buildSkill("Suplex", "Arremessa o alvo no chão causando dano Massivo em um alvo", "FISICO", "fa-person-falling", "1d10"));
            allSkills.add(buildSkill("Uppercut", "Causa dano massivo com chances de causar contusão (atordoamento)", "FISICO", "fa-burst", "1d10"));

            allSkills.add(buildSkill("Agni", "Dano leve de fogo a um alvo", "FOGO", "fa-fire", "1d6"));
            allSkills.add(buildSkill("Magni", "Dano leve de fogo a mais de um alvo", "FOGO", "fa-fire", "1d6"));
            allSkills.add(buildSkill("Agnari", "Dano moderado de fogo a um alvo", "FOGO", "fa-fire-flame-curved", "1d8"));
            allSkills.add(buildSkill("Magnar", "Dano moderado de fogo a mais de um alvo", "FOGO", "fa-fire-flame-curved", "1d8"));
            allSkills.add(buildSkill("Ignis", "Dano massivo de fogo a um alvo", "FOGO", "fa-fire-flame-simple", "1d10"));
            allSkills.add(buildSkill("Miragnis", "Dano Massivo de fogo a mais de um alvo", "FOGO", "fa-fire-flame-simple", "1d10"));
            allSkills.add(buildSkill("Ignitor", "Dano Severo de fogo a um alvo", "FOGO", "fa-dumpster-fire", "1d12"));
            allSkills.add(buildSkill("Maraginitor", "Dano Severo de fogo a mais de um alvo", "FOGO", "fa-dumpster-fire", "1d12"));
            allSkills.add(buildSkill("Inferno", "Golpe supremo de fogo", "FOGO", "fa-meteor", "1d20"));
            allSkills.add(buildSkill("Proteção de Calor", "Defesa contra golpes de fogo", "FOGO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de Calor", "Quebra defesas contra golpes de fogo", "FOGO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Calor", "Ganha resistência a golpes de fogo", "FOGO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Calor", "Repelir e contra atacar golpes de calor", "FOGO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade ao Calor", "Ganha imunidade a golpes de fogo", "FOGO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno de Calor", "Absorve golpes de fogo", "FOGO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Temperatura", "Aumenta seus golpes de fogo", "FOGO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Aqua", "Dano leve de agua a um alvo", "AGUA", "fa-droplet", "1d6"));
            allSkills.add(buildSkill("Maqua", "Dano leve de agua a mais de um alvo", "AGUA", "fa-droplet", "1d6"));
            allSkills.add(buildSkill("Aquate", "Dano moderado de agua a um alvo", "AGUA", "fa-water", "1d8"));
            allSkills.add(buildSkill("Maquate", "Dano moderado de agua a mais de um alvo", "AGUA", "fa-water", "1d8"));
            allSkills.add(buildSkill("Cryo", "Dano massivo de gelo a um alvo", "GELO", "fa-snowflake", "1d10"));
            allSkills.add(buildSkill("Macryo", "Dano Massivo de gelo a mais de um alvo", "GELO", "fa-snowflake", "1d10"));
            allSkills.add(buildSkill("Boreal", "Dano Severo de gelo a um alvo", "GELO", "fa-icicles", "1d12"));
            allSkills.add(buildSkill("Avalanche", "Dano Severo de gelo a mais de um alvo", "GELO", "fa-icicles", "1d12"));
            allSkills.add(buildSkill("Iceberg", "Golpe supremo de gelo", "GELO", "fa-mountain", "1d20"));
            allSkills.add(buildSkill("Proteção do Frio", "Defesa contra golpes de agua/gelo", "GELO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de Frio", "Quebra defesas contra golpes de agua/gelo", "GELO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Frio", "Ganha resistência a golpes de agua/gelo", "GELO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Frio", "Repelir e contra atacar golpes de frio", "GELO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade ao Frio", "Ganha imunidade a golpes de agua/gelo", "GELO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno de Frio", "Absorve golpes de agua/gelo", "GELO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Umidade", "Aumenta seus golpes de gelo/agua", "GELO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Rai", "Dano leve de eletricidade a um alvo", "RAIO", "fa-bolt", "1d6"));
            allSkills.add(buildSkill("Marai", "Dano leve de eletricidade a mais de um alvo", "RAIO", "fa-bolt", "1d6"));
            allSkills.add(buildSkill("Rarai", "Dano moderado de eletricidade a um alvo", "RAIO", "fa-bolt-lightning", "1d8"));
            allSkills.add(buildSkill("Mararai", "Dano moderado de eletricidade a mais de um alvo", "RAIO", "fa-bolt-lightning", "1d8"));
            allSkills.add(buildSkill("Bolt", "Dano massivo de eletricidade a um alvo", "RAIO", "fa-plug-circle-bolt", "1d10"));
            allSkills.add(buildSkill("Miraibol", "Dano Massivo de eletricidade a mais de um alvo", "RAIO", "fa-plug-circle-bolt", "1d10"));
            allSkills.add(buildSkill("Boltus", "Dano Severo de eletricidade a um alvo", "RAIO", "fa-cloud-bolt", "1d12"));
            allSkills.add(buildSkill("Marariboltus", "Dano Severo de eletricidade a mais de um alvo", "RAIO", "fa-cloud-bolt", "1d12"));
            allSkills.add(buildSkill("Tormenta", "Golpe supremo de Eletricidade", "RAIO", "fa-cloud-showers-heavy", "1d20"));
            allSkills.add(buildSkill("Proteção térmica", "Defesa contra golpes de eletricidade", "RAIO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de amperagem", "Quebra defesas contra golpes de eletricidade", "RAIO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Voltagem", "Ganha resistência a golpes eletricos", "RAIO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir voltagem", "Repelir e contra atacar golpes de eletricidade", "RAIO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Térmica", "Ganha imunidade a golpes de eletricidade", "RAIO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno de Energia", "Absorve golpes de eletricidade", "RAIO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Amperagem", "Aumenta seus golpes de eletricidade", "RAIO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Aero", "Dano leve de vento a um alvo", "VENTO", "fa-wind", "1d6"));
            allSkills.add(buildSkill("Maero", "Dano leve de vento a mais de um alvo", "VENTO", "fa-wind", "1d6"));
            allSkills.add(buildSkill("Aerion", "Dano moderado de vento a um alvo", "VENTO", "fa-fan", "1d8"));
            allSkills.add(buildSkill("Maerion", "Dano moderado de vento a mais de um alvo", "VENTO", "fa-fan", "1d8"));
            allSkills.add(buildSkill("Fuushe", "Dano massivo de vento a um alvo", "VENTO", "fa-tornado", "1d10"));
            allSkills.add(buildSkill("Mafuushe", "Dano Massivo de vento a mais de um alvo", "VENTO", "fa-tornado", "1d10"));
            allSkills.add(buildSkill("Fuushin", "Dano Severo de vento a um alvo", "VENTO", "fa-hurricane", "1d12"));
            allSkills.add(buildSkill("Marafuushin", "Dano Severo de vento a mais de um alvo", "VENTO", "fa-hurricane", "1d12"));
            allSkills.add(buildSkill("Vendaval", "Golpe supremo de Vento", "VENTO", "fa-cloud-showers-water", "1d20"));
            allSkills.add(buildSkill("Proteção aerea", "Defesa contra golpes de vento", "VENTO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de ventos", "Quebra defesas contra golpes de ventos", "VENTO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Vantania", "Ganha resistência a golpes de vento", "VENTO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Ventos", "Repelir e contra atacar golpes de Vento", "VENTO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Tempestuosa", "Ganha imunidade a golpes de vento", "VENTO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno Eólico", "Absorve golpes de vento", "VENTO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Movimento", "Aumenta seus golpes de vento", "VENTO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Geo", "Dano leve de terra a um alvo", "TERRENO", "fa-mountain", "1d6"));
            allSkills.add(buildSkill("Mageo", "Dano leve de terra a mais de um alvo", "TERRENO", "fa-mountain", "1d6"));
            allSkills.add(buildSkill("Geoda", "Dano moderado de terra a um alvo", "TERRENO", "fa-cubes", "1d8"));
            allSkills.add(buildSkill("Marageoda", "Dano moderado de terra a mais de um alvo", "TERRENO", "fa-cubes", "1d8"));
            allSkills.add(buildSkill("Tera", "Dano massivo de terra a um alvo", "TERRENO", "fa-hill-rockslide", "1d10"));
            allSkills.add(buildSkill("Matera", "Dano Massivo de terra a mais de um alvo", "TERRENO", "fa-hill-rockslide", "1d10"));
            allSkills.add(buildSkill("Terok", "Dano Severo de terra a um alvo", "TERRENO", "fa-earth-americas", "1d12"));
            allSkills.add(buildSkill("Matereokia", "Dano Severo de Terra a mais de um alvo", "TERRENO", "fa-earth-americas", "1d12"));
            allSkills.add(buildSkill("Gaia", "Golpe supremo de Terra", "TERRENO", "fa-globe", "1d20"));
            allSkills.add(buildSkill("Proteção terrena", "Defesa contra golpes de terra", "TERRENO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de terreno", "Quebra defesas contra golpes de terra", "TERRENO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Terras", "Ganha resistência a golpes de terra", "TERRENO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Areia", "Repelir e contra atacar golpes de terra", "TERRENO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Terrena", "Ganha imunidade a golpes de terra", "TERRENO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno de Terra", "Absorve golpes de terra", "TERRENO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Terreno", "Aumenta seus golpes de terra", "TERRENO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Psi", "Dano leve psiquico a um alvo", "PSIQUICO", "fa-brain", "1d6"));
            allSkills.add(buildSkill("Mapsi", "Dano leve psiquico a mais de um alvo", "PSIQUICO", "fa-brain", "1d6"));
            allSkills.add(buildSkill("Psio", "Dano moderado psiquico a um alvo", "PSIQUICO", "fa-head-side-virus", "1d8"));
            allSkills.add(buildSkill("Mapsio", "Dano moderado psiquico a mais de um alvo", "PSIQUICO", "fa-head-side-virus", "1d8"));
            allSkills.add(buildSkill("Psyon", "Dano massivo psiquico a um alvo", "PSIQUICO", "fa-eye", "1d10"));
            allSkills.add(buildSkill("Mipsyon", "Dano Massivo psiquico a mais de um alvo", "PSIQUICO", "fa-eye", "1d10"));
            allSkills.add(buildSkill("Psionidai", "Dano Severo psiquico a um alvo", "PSIQUICO", "fa-wave-square", "1d12"));
            allSkills.add(buildSkill("Marasionidae", "Dano Severo psiquico a mais de um alvo", "PSIQUICO", "fa-wave-square", "1d12"));
            allSkills.add(buildSkill("Pertubação", "Golpe supremo Psiquico", "PSIQUICO", "fa-disease", "1d20"));
            allSkills.add(buildSkill("Proteção psiquica", "Defesa contra golpes psiquicos", "PSIQUICO_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de Mente", "Quebra defesas contra golpes psiquicos", "PSIQUICO_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio Mental", "Ganha resistência a golpes psiquicos", "PSIQUICO_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Psiquico", "Repelir e contra atacar golpes psiquicos", "PSIQUICO_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Psiquica", "Ganha imunidade a golpes psiquicos", "PSIQUICO_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno Mental", "Absorve golpes psiquicos", "PSIQUICO_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Ascensão Mental", "Aumenta seus golpes psiquicos", "PSIQUICO_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Nuke", "Dano leve nuclear a um alvo", "NUCLEAR", "fa-radiation", "1d6"));
            allSkills.add(buildSkill("Manuke", "Dano leve nuclear a mais de um alvo", "NUCLEAR", "fa-radiation", "1d6"));
            allSkills.add(buildSkill("Alfa", "Dano moderado nuclear a um alvo", "NUCLEAR", "fa-atom", "1d8"));
            allSkills.add(buildSkill("Malfa", "Dano moderado nuclear a mais de um alvo", "NUCLEAR", "fa-atom", "1d8"));
            allSkills.add(buildSkill("Beta", "Dano massivo nuclear a um alvo", "NUCLEAR", "fa-biohazard", "1d10"));
            allSkills.add(buildSkill("Meta", "Dano Massivo nuclear a mais de um alvo", "NUCLEAR", "fa-biohazard", "1d10"));
            allSkills.add(buildSkill("Gama", "Dano Severo nuclear a um alvo", "NUCLEAR", "fa-skull-crossbones", "1d12"));
            allSkills.add(buildSkill("Magama", "Dano Severo nuclear a mais de um alvo", "NUCLEAR", "fa-skull-crossbones", "1d12"));
            allSkills.add(buildSkill("Manhattan", "Golpe supremo nuclear", "NUCLEAR", "fa-bomb", "1d20"));
            allSkills.add(buildSkill("Proteção de Chumbo", "Defesa contra golpes nucleares", "NUCLEAR_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de radiação", "Quebra defesas contra golpes radioativos", "NUCLEAR_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Radiação", "Ganha resistência a golpes nucleares", "NUCLEAR_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Radio", "Repelir e contra atacar golpes nucleares", "NUCLEAR_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade nuclear", "Ganha imunidade a golpes radioativos", "NUCLEAR_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno Gama", "Absorve golpes radioativos", "NUCLEAR_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Explosão", "Aumenta seus golpes nucleares", "NUCLEAR_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Or", "Dano leve de luz a um alvo", "LUZ", "fa-sun", "1d6"));
            allSkills.add(buildSkill("Mor", "Dano leve de luz a mais de um alvo", "LUZ", "fa-sun", "1d6"));
            allSkills.add(buildSkill("Orum", "Dano moderado de luz a um alvo", "LUZ", "fa-lightbulb", "1d8"));
            allSkills.add(buildSkill("Morum", "Dano moderado de luz a mais de um alvo", "LUZ", "fa-lightbulb", "1d8"));
            allSkills.add(buildSkill("Phor", "Dano massivo de luz a um alvo", "LUZ", "fa-star", "1d10"));
            allSkills.add(buildSkill("Miraphor", "Dano Massivo de luz a mais de um alvo", "LUZ", "fa-star", "1d10"));
            allSkills.add(buildSkill("Osphoros", "Dano Severo de luz a um alvo", "LUZ", "fa-bahai", "1d12"));
            allSkills.add(buildSkill("Maraphorus", "Dano Severo de luz a mais de um alvo", "LUZ", "fa-bahai", "1d12"));
            allSkills.add(buildSkill("Lucifer", "Golpe supremo de luz", "LUZ", "fa-sun-plant-wilt", "1d20"));
            allSkills.add(buildSkill("Chen", "Leve chance de insta-kill para um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Machen", "Leve chance de insta-kill para mais de um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Chenis", "Chance média de Insta-kill para um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Machenis", "Chance média de insta-kill para mais de um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Chenar", "Altas chances de Insta-kill para um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Machenar", "Altas chances de insta-kill para mais de um alvo", "LUZ_MORTAL", "fa-crosshairs", null));
            allSkills.add(buildSkill("Proteção violeta", "Defesa contra golpes de luz", "LUZ_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de luz", "Quebra defesas contra golpes de luz", "LUZ_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Luz", "Ganha resistência a golpes de luz", "LUZ_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir Luminosidade", "Repelir e contra atacar golpes de luz", "LUZ_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Luminosa", "Ganha imunidade a golpes de luz", "LUZ_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno violeta", "Absorve golpes de luz", "LUZ_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Resistência", "Aumenta seus golpes de luz", "LUZ_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Tzel", "Dano leve de trevas a um alvo", "TREVAS", "fa-moon", "1d6"));
            allSkills.add(buildSkill("Mtzel", "Dano leve de treva a mais de um alvo", "TREVAS", "fa-moon", "1d6"));
            allSkills.add(buildSkill("Tzor", "Dano moderado de treva a um alvo", "TREVAS", "fa-cloud-moon", "1d8"));
            allSkills.add(buildSkill("Matzor", "Dano moderado de treva a mais de um alvo", "TREVAS", "fa-cloud-moon", "1d8"));
            allSkills.add(buildSkill("Umbra", "Dano massivo de treva a um alvo", "TREVAS", "fa-eclipse", "1d10"));
            allSkills.add(buildSkill("Mumbra", "Dano Massivo de treva a mais de um alvo", "TREVAS", "fa-eclipse", "1d10"));
            allSkills.add(buildSkill("Umbris", "Dano Severo de treva a um alvo", "TREVAS", "fa-crow", "1d12"));
            allSkills.add(buildSkill("Marumbra", "Dano Severo de treva a mais de um alvo", "TREVAS", "fa-crow", "1d12"));
            allSkills.add(buildSkill("Penumbra", "Golpe supremo de Treva", "TREVAS", "fa-ghost", "1d20"));
            allSkills.add(buildSkill("Qalal", "Leve chance de insta-kill para um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Malal", "Leve chance de insta-kill para mais de um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Qilal", "Chance média de Insta-kill para um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Maquila", "Chance média de insta-kill para mais de um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Deta", "Altas chances de Insta-kill para um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Mara", "Altas chances de insta-kill para mais de um alvo", "TREVAS_MORTAL", "fa-skull", null));
            allSkills.add(buildSkill("Proteção Obscura", "Defesa contra golpes de Trevas", "TREVAS_SUPORTE", "fa-shield", null));
            allSkills.add(buildSkill("Quebra de Sombras", "Quebra defesas contra golpes de Trevas", "TREVAS_SUPORTE", "fa-heart-crack", null));
            allSkills.add(buildSkill("Bloqueio de Obscuridade", "Ganha resistência a golpes de treva", "TREVAS_SUPORTE", "fa-shield-halved", null));
            allSkills.add(buildSkill("Repelir sombras", "Repelir e contra atacar golpes de trevas", "TREVAS_SUPORTE", "fa-reply-all", null));
            allSkills.add(buildSkill("Imunidade Umbra", "Ganha imunidade a golpes de Trevas", "TREVAS_SUPORTE", "fa-ban", null));
            allSkills.add(buildSkill("Dreno Sombrio", "Absorve golpes de Trevas", "TREVAS_SUPORTE", "fa-battery-full", null));
            allSkills.add(buildSkill("Aumento de Sombra", "Aumenta seus golpes de Trevas", "TREVAS_SUPORTE", "fa-arrow-up", null));

            allSkills.add(buildSkill("Raf", "Cura leve a um alvo", "CURA", "fa-heart", null));
            allSkills.add(buildSkill("Maraf", "Cura em espaço", "CURA", "fa-house-medical", null));
            allSkills.add(buildSkill("Rapha", "Cura média a um alvo", "CURA", "fa-heart-pulse", null));
            allSkills.add(buildSkill("Marapha", "Cura média em espaço", "CURA", "fa-hospital", null));
            allSkills.add(buildSkill("Aeon", "Cura alta a um alvo", "CURA", "fa-kit-medical", null));
            allSkills.add(buildSkill("Malva", "Cura alta em espaço", "CURA", "fa-briefcase-medical", null));
            allSkills.add(buildSkill("El", "Cura completa", "CURA", "fa-star-of-life", null));

            String[] pericias = {
                    "Lúcidez / Firmeza Mental", "Investigação & Análise", "Instinto de Preservação", "Mimetismo Social",
                    "Sexto Sentido", "Cântico / Ressonância", "Alquimia & Química", "Visão do Invisível",
                    "Litomancia / Geometria dos Sonhos", "Discernimento", "Expurgo", "Empatia / Intuição Social",
                    "Comunhão / Oração", "Aura de Proteção", "Diplomacia", "Botânica & Fauna", "Tolerância Biológica",
                    "Ancoragem", "Sobrevivência Física", "Medicina / Anatomia", "Liderança & Comando",
                    "Estratégia & Tática", "Engenharia & Mecânica", "Autoridade Espiritual", "Vigor de Batalha",
                    "Fé", "Religião", "Folclore & Lendas", "Ofício / Criação", "Avaliação / Perícia de Bens",
                    "Destreza Fina", "Arquitetura & Edificações", "Pugna Pesada", "Fortitude", "Força Biomecânica",
                    "Geografia & Cartografia", "Criptografia & Códigos", "Navegação & Astrologia",
                    "Lábia das Ruas / Malandragem", "Ligeireza", "Enganação", "Negociação / Comércio", "Acrobacia",
                    "Atletismo", "Briga", "Intimidação", "Vitalidade / Regeneração", "Furtividade", "Arquaria & Disparo",
                    "Presença Espetacular", "Persuasão", "Sanidade", "Etiqueta & Ritos", "Mimetismo"
            };

            for (String p : pericias) {
                allSkills.add(buildSkill(p, "Perícia do Arquétipo", "PERICIA", "fa-book", null));
            }

            skillRepository.saveAll(allSkills);
            System.out.println("Catálogo populado! Total de Habilidades/Perícias registradas: " + allSkills.size());
        }
    }

    private Skill buildSkill(String name, String desc, String category, String iconRef, String damageDice) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setDescription(desc);
        skill.setCategory(category);
        skill.setIconRef(iconRef);
        skill.setDamageDice(damageDice);
        return skill;
    }
}