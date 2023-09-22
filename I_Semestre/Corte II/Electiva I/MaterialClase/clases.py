import traceback

class MobilePhone:

    manufacturer: str
    scrren_size: float
    num_cores: int
    apps: list[str]
    status: bool

    def  __init__(
            self, 
            manufacturer: str, 
            screen_size: float,
            num_cores: int,
            apps: list[str] = [],
            status: bool = False
        ) -> None:
        self.manufacturer = manufacturer
        self.scrren_size = screen_size
        self.num_cores = num_cores
        self.apps = apps
        self.status = status
        self.name()

    def power_on(self: object) -> None:
        if self.status:print("El celular ya está encendido")
        else: 
            self.status = True
            print(f"El celular se ha encendido.")

    def power_off(self: object) -> None:
        if not self.status: print("El celular ya está apagado")
        else: 
            self.status = False
            print("El celular se ha apagado.")

    def install_app(self: object, *apps: str) -> None:
        if self.status:
            for app in apps:
                if app in self.apps: print(f"La aplicación {app} ya se encuentra instalada.")
                else:
                    self.apps.append(app)
                    print(f"La aplicación {app} se ha instalado.")
        
        else: print("Encienda el teléfono")
    
    def uninstall_app(self: object, *apps: str) -> None:
        if self.status:
            for app in apps:
                if app not in self.apps: print(f"La aplicación {app} no se encuentra instalada.")
                else:
                    self.apps.remove(app)
                    print(f"La aplicación {app} se ha desinstalado.")

        else: print("Encienda el teléfono")

redmi_note_10s = MobilePhone("Tigo", 7, 8)
redmi_note_10s.power_on()
redmi_note_10s.install_app("Whatsapp", "Instagram", "Facebok", "Slack", "Solitario")
redmi_note_10s.uninstall_app("Solitario", "Snake")
redmi_note_10s.install_app("Whatsapp")
redmi_note_10s.power_on()
redmi_note_10s.power_off()