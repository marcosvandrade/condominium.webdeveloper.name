import { http } from './config'

export default {

    salvar:(usuarios) => {
        return http.post('usuarios', usuarios);
    }

}
