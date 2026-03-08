# janistream 🎌

[🇧🇷 Leia em Português](README.pt.md)

> Stream anime directly in your terminal. No browser, no downloads, no ads.

Built in pure Java, using yt-dlp for stream resolution and mpv for playback.

---

## How it works

```
User searches for an anime
        ↓
Jikan API (MyAnimeList) returns results
        ↓
User selects anime and episode
        ↓
yt-dlp resolves stream URL
        ↓
mpv plays the stream directly
(nothing is saved to disk)
```

---

## Requirements

| Tool | Install |
|------|---------|
| [yt-dlp](https://github.com/yt-dlp/yt-dlp) | `pip install yt-dlp` |
| [mpv](https://mpv.io/) | `sudo dnf install mpv` |
| Java 17+ | [Download](https://www.oracle.com/br/java/technologies/downloads/) |

---

## Installation

```bash
git clone https://github.com/caioreis29974/janistream.git
cd janistream
mvn package -DskipTests
java -jar target/janistream-1.0-SNAPSHOT.jar --query "Naruto"
```

---

## Usage

```bash
# Search and stream
java -jar target/janistream-1.0-SNAPSHOT.jar --query "Attack on Titan"

# Show help
java -jar target/janistream-1.0-SNAPSHOT.jar --help
```

### Navigation

| Key | Action |
|-----|--------|
| `↑` / `↓` | Navigate |
| `Enter` | Select |

---

## Tech Stack

- **Java 17**
- **Picocli** — CLI argument parsing
- **JLine3** — interactive terminal menus
- **OkHttp** — HTTP client
- **Gson** — JSON parsing
- **yt-dlp** — stream resolution
- **mpv** — media player

---

## Architecture

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

## License

MIT — see [LICENSE](LICENSE)

---

<p align="center">Made with ☕ by <a href="https://github.com/caioreis29974">caioxyz</a></p>
