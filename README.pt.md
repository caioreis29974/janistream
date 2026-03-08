# janistream 🎌

[🇺🇸 Read in English](README.md)

> Assista anime diretamente no seu terminal. Sem navegador, sem downloads, sem anúncios.

Feito em Java puro, usando yt-dlp para resolução do stream e mpv para reprodução.

---

## Como funciona

```
Usuário busca um anime
        ↓
API Jikan (MyAnimeList) retorna os resultados
        ↓
Usuário seleciona o anime e o episódio
        ↓
yt-dlp resolve a URL do stream
        ↓
mpv reproduz diretamente
(nada é salvo no disco)
```

---

## Requisitos

| Ferramenta | Instalação |
|------------|------------|
| [yt-dlp](https://github.com/yt-dlp/yt-dlp) | `pip install yt-dlp` |
| [mpv](https://mpv.io/) | `sudo dnf install mpv` |
| Java 17+ | [Download](https://www.oracle.com/br/java/technologies/downloads/) |

---

## Instalação

```bash
git clone https://github.com/caioreis29974/janistream.git
cd janistream
mvn package -DskipTests
java -jar target/janistream-1.0-SNAPSHOT.jar --query "Naruto"
```

---

## Uso

```bash
# Buscar e assistir
java -jar target/janistream-1.0-SNAPSHOT.jar --query "Attack on Titan"

# Ajuda
java -jar target/janistream-1.0-SNAPSHOT.jar --help
```

### Navegação

| Tecla | Ação |
|-------|------|
| `↑` / `↓` | Navegar |
| `Enter` | Selecionar |

---

## Tecnologias

- **Java 17**
- **Picocli** — parsing de argumentos CLI
- **JLine3** — menus interativos no terminal
- **OkHttp** — cliente HTTP
- **Gson** — parsing de JSON
- **yt-dlp** — resolução do stream
- **mpv** — reprodutor de mídia

---

## Arquitetura

```
src/main/java/dev/janistream/
├── Main.java
├── api/
│   └── JikanClient.java
├── model/
│   ├── Anime.java
│   ├── Episode.java
│   ├── JikanResponse.java
│   └── JikanEpisodeResponse.java
├── player/
│   └── StreamPlayer.java
└── ui/
    └── TerminalUI.java
```

---

## Licença

MIT — veja [LICENSE](LICENSE)

---

<p align="center">Feito com ☕ por <a href="https://github.com/caioxyz">caioxyz</a></p>
