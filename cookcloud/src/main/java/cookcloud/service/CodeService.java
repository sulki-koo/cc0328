package cookcloud.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cookcloud.entity.Code;
import cookcloud.entity.CodeId;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CodeService {

	private static Map<CodeId, Code> codeData;

	public void getAllCode(HttpServletRequest request) {
		if (codeData != null && !codeData.isEmpty()) {
			codeData = (Map<CodeId, Code>) request.getServletContext().getAttribute("codeMap");
		}
	}

	public Map<CodeId, Code> getRecipeTypes() {
		return codeData.entrySet().stream()
				.filter(entry -> entry.getKey().getParentCode() == 5L)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // 필터링된 코드만 반환

	}

}
