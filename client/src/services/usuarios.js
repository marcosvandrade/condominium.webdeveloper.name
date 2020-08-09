import { http } from '../plugins/axios'

export default {

    salvar:(usuario) => {
        return http.post('cadastro', usuario);
    }

}
