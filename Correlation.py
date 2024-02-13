import pandas as pd
from scipy.stats import pearsonr, spearmanr, kendalltau
import json



def calculate_pearson(project_name):
    if project_name == "checkstyle":
        checkstyle_df = pd.read_csv('checkstyle.csv')
        size = checkstyle_df['SLOC']
        McCabe = checkstyle_df['McCabe']
        readability = checkstyle_df['Readability']
        revisions = checkstyle_df['Number of Revisions']
        correlation_coefficient, p_value = pearsonr(size, McCabe)
        final_result['checkstyle'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = pearsonr(size, readability)
        final_result['checkstyle']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(size, revisions)
        final_result['checkstyle']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(McCabe, readability)
        final_result['checkstyle']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(McCabe, revisions)
        final_result['checkstyle']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(readability, revisions)
        final_result['checkstyle']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
    else:
        hadoop_df = pd.read_csv('hadoop.csv')
        size = hadoop_df['SLOC']
        McCabe = hadoop_df['McCabe']
        readability = hadoop_df['Readability']
        revisions = hadoop_df['Number of Revisions']
        correlation_coefficient, p_value = pearsonr(size, McCabe)
        final_result['hadoop'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = pearsonr(size, readability)
        final_result['hadoop']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(size, revisions)
        final_result['hadoop']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(McCabe, readability)
        final_result['hadoop']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(McCabe, revisions)
        final_result['hadoop']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = pearsonr(readability, revisions)
        final_result['hadoop']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}



def calculate_spearman(project_name):
    if project_name == "checkstyle":
        checkstyle_df = pd.read_csv('checkstyle.csv')
        size = checkstyle_df['SLOC']
        McCabe = checkstyle_df['McCabe']
        readability = checkstyle_df['Readability']
        revisions = checkstyle_df['Number of Revisions']
        correlation_coefficient, p_value = spearmanr(size, McCabe)
        final_result['checkstyle'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = spearmanr(size, readability)
        final_result['checkstyle']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(size, revisions)
        final_result['checkstyle']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(McCabe, readability)
        final_result['checkstyle']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(McCabe, revisions)
        final_result['checkstyle']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(readability, revisions)
        final_result['checkstyle']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
    else:
        hadoop_df = pd.read_csv('hadoop.csv')
        size = hadoop_df['SLOC']
        McCabe = hadoop_df['McCabe']
        readability = hadoop_df['Readability']
        revisions = hadoop_df['Number of Revisions']
        correlation_coefficient, p_value = spearmanr(size, McCabe)
        final_result['hadoop'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = spearmanr(size, readability)
        final_result['hadoop']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(size, revisions)
        final_result['hadoop']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(McCabe, readability)
        final_result['hadoop']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(McCabe, revisions)
        final_result['hadoop']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = spearmanr(readability, revisions)
        final_result['hadoop']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}


def calculate_kendalltau(project_name):
    if project_name == "checkstyle":
        checkstyle_df = pd.read_csv('checkstyle.csv')
        size = checkstyle_df['SLOC']
        McCabe = checkstyle_df['McCabe']
        readability = checkstyle_df['Readability']
        revisions = checkstyle_df['Number of Revisions']
        correlation_coefficient, p_value = kendalltau(size, McCabe)
        final_result['checkstyle'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = kendalltau(size, readability)
        final_result['checkstyle']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(size, revisions)
        final_result['checkstyle']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(McCabe, readability)
        final_result['checkstyle']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(McCabe, revisions)
        final_result['checkstyle']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(readability, revisions)
        final_result['checkstyle']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
    else:
        hadoop_df = pd.read_csv('hadoop.csv')
        size = hadoop_df['SLOC']
        McCabe = hadoop_df['McCabe']
        readability = hadoop_df['Readability']
        revisions = hadoop_df['Number of Revisions']
        correlation_coefficient, p_value = kendalltau(size, McCabe)
        final_result['hadoop'] = {"size_McCabe": {"correlation_coefficient": correlation_coefficient, "p_value": p_value}}
        correlation_coefficient, p_value = kendalltau(size, readability)
        final_result['hadoop']["size_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(size, revisions)
        final_result['hadoop']["size_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(McCabe, readability)
        final_result['hadoop']["McCabe_readability"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(McCabe, revisions)
        final_result['hadoop']["McCabe_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}
        correlation_coefficient, p_value = kendalltau(readability, revisions)
        final_result['hadoop']["readability_revision"] = {"correlation_coefficient": correlation_coefficient, "p_value": p_value}


def json_creator(final_result):

    json_file_path = "final_result.json"

    with open(json_file_path, 'w') as json_file:
        for key, value in final_result.items():
            json.dump({key: value}, json_file)
            json_file.write('\n')

final_result = dict()
calculate_pearson("checkstyle")
calculate_pearson("hadoop")
calculate_spearman("checkstyle")
calculate_spearman("hadoop")
calculate_kendalltau("checkstyle")
calculate_kendalltau("hadoop")
json_creator(final_result=final_result)
